$(document).ready(function(){
    $(".text-field>input").focus(function(){
        $(this).parent(".text-field").addClass("focus");
    });

    $(".text-field>input").blur(function(){
        $(this).parent(".text-field").removeClass("focus");
    });
});/**
 * Created by banhtieu on 9/3/15.
 */
