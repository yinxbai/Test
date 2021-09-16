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
                'name': {
                    required: true
                }
            },
            messages: {
                'name': {
                    required: '请输入班级名称'
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
