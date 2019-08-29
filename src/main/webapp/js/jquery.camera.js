
(function ($, window, document, undefined) {

    var onFailSoHard;
    var snapShot;
    var localMediaStream;
    var photoToSave;
    var canvas;
    var ctx;
    var tmpPhoto;

    var video;

    var div_ac_display;
    var div_cam_stream;
    var div_cam_take;
    var div_cam_temp;
    var div_cam_download;
    var div_cam_export;

    var settings;

    var cameraAC = "cameraAC",
            defaults = {
                width: 160,
                height: 120,
                audio: true
            };

    function Plugin(element, options) {
        this.element = element;
        this.settings = $.extend({}, defaults, options);
        this._defaults = defaults;
        this._name = cameraAC;

        this.init();
    }

    $.extend(Plugin.prototype, {
        init: function () {
            console.log(this.settings);
            console.log('\n');
            $(this.element).addClass('ac-camera');

            var elements = [
                $('<video>', {
                    id: 'ac-cam-steam',
                    class: 'ac-camera',
                    autoplay: 'autoplay',
                    height: this.settings.height,
                    width: this.settings.width
                }),
                $('<canvas>', {
                    id: 'ac-cam-photo',
                    class: 'ac-camera',
                    style: 'display:',
                    height: this.settings.height,
                    width: this.settings.width
                }),
                $('<img>', {
                    id: 'ac-cam-temp',
                    class: 'ac-camera',
                    style: 'display:',
                    height: this.settings.height,
                    width: this.settings.width
                }),
                $('<div>', {
                    id: 'ac-cam-take',
                    class: 'ac-camera ac-icon',
                    html: $('<img>', {
                        src: 'data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAGQAAABkCAMAAABHPGVmAAAAh1BMVEVMaXH///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////8s+2B1AAAALHRSTlMA9evRAyj+iJn5Rec/UtnhGX2AITdLHe+gkDBleAjIqwxdk7Zpb6YPw7O5t9JNvvkAAAKKSURBVHhe7ZjZkqMwDEVtYrYQIEAWtixk62RG//998xBEVTo20C11TT9wXlOVU7Zkc2Xx25mYmJiY+AgTV0sSfjApjq4EI9I9cjjsCHqJbLojC2CAYEOW3GGQO9UxhxHMiZIDjOBGbF4JI5C0Rr7AKC4kyR5Gsac4bBiJ/cXzHdaFh9xhJHcPKepw6A6wDz6Q8Q+9C0tQQdXURoXKgY1cGSQuMOLqHWtgZa1zqAhYiXQbFgL8/FI8YMbTSGbAzEwjsYAZSyNxYJjollRNU6W3CIZxNJLh5V+XomN5Hd7er0tmb82ynjFL/FrT9ar2OSXxSmhZxXySyJissohLEqNDwzLmkWxtgezWp8d+/zitdwKxtyySULQc020nTo+iJeSQdMlt8ZKKg0WX/+gSiSew8eEFv8GySLKkwKPnwCcc3McTVeJkbX2luSNsqgSz4R/Q8BdzJlGStEUHLW3xU5oE/yYHLTkOMTTJs7dUAFoC9ewvmkQ+f9uAgfbCkSRJ0N62YKC9nQOSJMZN758W4x9dSWkKIfw1UT65u3A/zAvdAE0y742XHs85SfuK4rTN5RIls76PxgETLlGCc22maSArI9zC2my+eOsgH59UcrLEz/BbLuEFGWIs8skSeIiW8iVjRaVoOXOklaYLRNcAWoJrF4oq4JDIUiBqlebnc56ulEBKySIByx58PaRLIChNDjvmS/XWXO+YW5zziePuxBs712GetOJGiRdUE3NOWqhJbdFRpjEM8c3p1zoX9eVSF2frm9OvBcwE/+tF4gTMnHifu8Y/rivm/Zop7fF1gBHHcEkkwEiiEXDXvhBGLhJYkJXoYeltgczWW4p+1KJKXAJJtVDiFzExMTEx8Q+qqf2zSC90gwAAAABJRU5ErkJggg=='
                    })
                }),
                $('<div>', {
                    id: 'ac-cam-retake',
                    class: 'ac-camera ac-retake ac-icon',
                    style: 'display: none',
                    html: $('<img>', {
                        src: 'data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAGQAAABkCAMAAABHPGVmAAAAZlBMVEVMaXH///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////9FN16zAAAAIXRSTlMAqswR0Lmiu+iLMfgE8ZLD2l3kSgsXmnc6gVazIG+nPs8B5+N8AAABs0lEQVR4Xu2Z246DIBRFsdjaitCC16q98P8/OVWhGade0GMymclZbzskLkWMkE3GQZBEZlXwQZXJZDNFlHM9As+jbRz0rCc4002m6qkn2SUEjtAzCLgjZXMSloIlVz3LFeqIlO64BB9czJCCrrDSLqKhC+3NYAmUnKeuE9s7gDnC6RmxExaCJNn0u83NcAZxUD69Sikz4xQguemOOxnhoDtuAImd84KMUNgFTtx4BLuf+NqwG0Ub/I+R4DEgUXpj1IBEbw5UghJ/a8dzQFILr8F8GsxbATMfTRtETUY56ZYjWcFRt5xM/HMSlKAEJUn4IiUW2kT6jmkTE6ik4E1i0sSYtTE2UbaRF0BJ1t8jVl30+vvLDCg5dNHv7373/d/D4Z9IUIISlKAEJShBCUpQghKUoET0T1re4ElLACWhahKPTSx475AYt1GF4CM2fRG9UzQQf+EcjxKUzPWKbI2EmW7KufyplztqWws5F4v5comt0WLn2+HpUkfKdQd177FUsBBluymnhwYi3bpFEJeIOCBhkti1i50FXs5H9/UOQZyRfJ3iWJIFJFJUwUIqUX5/5wjyBUHVZHOOR/UBAAAAAElFTkSuQmCC'
                    })
                }),
                $('<div>', {
                    id: 'ac-cam-download',
                    class: 'ac-camera ac-retake ac-icon',
                    style: 'display: none',
                    html: $('<img>', {
                        src: 'data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAGQAAABkCAMAAABHPGVmAAAAXVBMVEVMaXH///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////8T8+gCAAAAHnRSTlMAjOr4mY+G3XZmfBwPA9JTgatLRsj9OaJbKrZx9cmatNqiAAABjklEQVR4Xu3Z626DMAyAURMu67iEci3Q1u//mNMQkqORjqayNa3y9x8dkEgwCrx1mqZpZWQ/nGxU8hvVHX90r9iRFne17Mh1j1zZkdMeOSnyIEUUUUQRRRRRpE0Tp36P9IlT2jHduhvLg5VxKBKXwciIwY3BSDGEGkMBwZ1DkTO8UBZmpAByChlyChlyChlyChlyChlyChlyChlyChlyChlyChlyChlyChlyChlyChlyChlyChlyChlCCoNRjdOntxq2ItyKYKv1XzGNld+YLT4qcxXXyPFRdvYZhXlmEokODMoUHuTy3LxTN01Nxm8lHsQETVXHBhoPcjQx5oEGDh4Ej8pDp/5XEMyc17LKUAbBpYCtYkEpBOOkLQHKNolRBCGIAH6Eel/kUk8LbplTdzUCSO5sSreZdkFOxKyrp3A/Mzk7YmEtdk47JlaEft9nXLvAdyk7gk0FUPa4NtQA0MX8CNooNbg1LOdm+ON1cuM2bh6k50Z6D1JzI7V/dGMtA29dYz+Ysk0H/ztN07QvdGtmMc0rv+oAAAAASUVORK5CYII='
                    })
                }),
                $('<div>', {
                    id: 'ac-cam-use',
                    class: 'ac-camera ac-retake ac-icon',
                    style: 'display: none',
                    html: $('<img>', {
                        src: 'data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAGQAAABkCAMAAABHPGVmAAAAflBMVEVMaXH///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////+cf0nxAAAAKXRSTlMAgDP5Eb+f7lVACQUZ1Hf8owHl6jhBmI9QaCDEXIlj9bXI4M2tbkYnLXg0S2QAAAIdSURBVHhe7dbrrqIwGIXhAqjbQjltRUQAB4/r/m9wTgnVBGr7aSeZpO9PA3mQhQZmI5fL5XK58nrzZV61ifWJeleA2CnhWkTuBaCH7y8Ngx/xZt5LI8/wdvtXyB7vF9zUBi/wgY5qpMFHqpXIGR/pokQGfKRSifTjcf3KuF5zFIytmXHeePLif0Uc4hCHdFwT8Qs6Up5CTSVckJEWItZUopaKJMBwZ5o1PQ1pAPSVruIPJOQOAGnCVF2jh2EoSJTid2fV/MtD/DAMAWECfyq2CgTF5mGYozmyw9/Sls8jCDo2Fpsj1/HDoslnEaCUw5gjvMfYwZ9HcIjpCMsgw9mfReQwBGSNpxYNn0EQdGQkF3hulVV8ApHDaCPqd/3g4FV1/ozIYShINGCyXhyXOy9JkhNkxYaGsA4GBR0NiQRMKiMKwvwUJh1iCsJaGFVsKAgXgNkwBITdVgBhGDOEVSlAGMYMYReAMIwhwjyAMIwC2ftjd+NHTLabQKbHzfh4xwx3+d5OIAKT/RgnrHroJM+bqHx5RTcB7TLOprrOTrgff5U7aKR6VctPGpe1FaQ5ZOtU4wZHXk+ZQ5ZoXVvorShzSCWFYhjJXASUB6q7Ks5eRkzmt8L0f16WV9kQ6N3quGmPg+oYNRTONHWvw/r8/G3ttHz6dVhD5BNoHTnVzDqScWYTkXNYROQcFhE5h0VEzmGvMmH2C9k/yeVyuVyun4T+lYz2Frc1AAAAAElFTkSuQmCC'
                    })
                })
            ];

            if (this.hasGetUserMedia) {

                navigator.getUserMedia = navigator.getUserMedia || navigator.webkitGetUserMedia
                        || navigator.mozGetUserMedia || navigator.msGetUserMedia;
                $(this.element).css({
                    "height": this.settings.height,
                    "width": this.settings.width,
                    "margin": "0 auto"
                }).append(elements);

                window.URL = window.URL || window.webkitURL;
                video = document.getElementById("ac-cam-steam");

                if (navigator.getUserMedia) {
                    navigator.getUserMedia({
                        audio: this.settings.audio,
                        video: true
                    }, function (stream) {
                      video = document.querySelector('video'); 
                        video.src = window.URL.createObjectURL(stream);
                        localMediaStream = stream;
                    }, this.onFailSoHard);
                    
                    this.snapShot(this.settings);
                    
                } else {
                    video.src = 'somevideo.webm'; // fallback.
                }
            } else {
                alert('jQuery Camera ac is not supported in this browser.\r\nTry another one or update it.');
            }            
        },
        hasGetUserMedia: function () {
            return !!(navigator.getUserMedia || navigator.webkitGetUserMedia ||
                    navigator.mozGetUserMedia || navigator.msGetUserMedia);
        },
        onFailSoHard: function (e) {
            console.log('jQuery Camera ac error: ', e);
        },
        snapShot: function (settings) {
            $("#ac-cam-take").click(function () {
                $("#ac-cam-take").fadeOut('1');
                $(".ac-retake").fadeIn('1');
                
                canvas = document.getElementById("ac-cam-photo");
                ctx = canvas.getContext("2d");
                if (localMediaStream) {
                    ctx.drawImage(video, 0, 0, settings.width, settings.height);
                    photoToSave = canvas.toDataURL("image/jpeg");
                    document.getElementById("ac-cam-temp").src = photoToSave;
                    photoToSave = photoToSave.replace("image/jpeg","image/octet-stream");
                }
            });
        }
    });
    
    $.fn[ cameraAC ] = function (options) {
        return this.each(function () {
            if (!$.data(this, "plugin_" + cameraAC)) {
                $.data(this, "plugin_" + cameraAC, new Plugin(this, options));
            }
        });
    };

})(jQuery, window, document);

$('#ac-display').cameraAC({width: 320, height: 240});