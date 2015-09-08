/**
 * Created by banhtieu on 9/8/15.
 *
 */

var socket = new SockJS('/talk');
stompClient = Stomp.over(socket);

stompClient.connect({}, function(frame) {
    console.log('Connected: ' + frame);

});

stompClient.subscribe('/topic/greeting', function(greeting){
    console.log(JSON.parse(greeting));
});