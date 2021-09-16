/*
Document: base_forms_validation.js
Author: Rustheme
Description: Custom JS code used in Form Validation Page
 */

var BaseFormValidation = function() {
    // Init Bootstrap Forms Validation: https://github.com/jzaefferer/jquery-validation
    var initValidationBootstrap = function() {
        jQuery( '.js-validation-bootstrap' ).validate({
            errorClass: 'help-block animated fadeInDown',
            errorElement: 'div',
            errorPlacement: function( error, e ) {
                jQuery(e).parents( '.form-group > div' ).append( error );
            },
            highlight: function(e) {
                jQuery(e).closest( '.form-group' ).removeClass( 'has-error' ).addClass( 'has-error' );
                jQuery(e).closest( '.help-block' ).remove();
            },
            success: function(e) {
                jQuery(e).closest( '.form-group' ).removeClass( 'has-error' );
                jQuery(e).closest( '.help-block' ).remove();
            },
            rules: {
                'title': {
                    required: true,
                    minlength: 3
                },
                'ppt': {
                    required: true
                },
                'video': {
                    required: true
                },
                'exercise': {
                    required: true
                }
            },
            messages: {
                'title': {
                    required: '请输入标题',
                    minlength: '长度不能低于3个字符'
                },
                'ppt': {
                    required: '请上传课件'
                },
                'video': {
                    required: '请上传视频'
                },
                'exercise': {
                    required: '请上传作业'
                }
            }
        });
    };

    // Init Material Forms Validation: https://github.com/jzaefferer/jquery-validation


    return {
        init: function () {
            // Init Bootstrap Forms Validation
            initValidationBootstrap();
        }
    };
}();

// Initialize when page loads
jQuery( function() {
    BaseFormValidation.init();
});
