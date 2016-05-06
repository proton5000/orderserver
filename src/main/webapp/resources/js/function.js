/**
 * Created by proton on 17.03.2016.
 */
function login() {

    var login = $('#formLoginJs').serialize();

    $.ajax({
        url: 'login',
        type: 'post',
        data: login,
        dataType: 'json',
        success: function (data) {

            $('#formLoginJsInfo').remove();
            $('#formLoginJs').append('<div id="formLoginJsInfo">пользователь существует<br>'+
            'id: '+data.id+' name: '+data.name+' password: '+data.password+' email: '+data.email+'</div>');
        },
        error: function (error) {
            $('#formLoginJsInfo').remove();
            $('#formLoginJs').append('<div id="formLoginJsInfo">логин/пароль не существует <br>'+error.responseText+'</div>');
            console.log(error);
        }
    });
}

function addUser() {

    var addUser = $('#formAddUserJs').serialize();

    $.ajax({
        url: 'addUser',
        type: 'post',
        data: addUser,
        dataType: 'json',
        success: function (data) {
            $('#formAddUserJsInfo').remove();
            $('#formAddUserJs').append('<div id="formAddUserJsInfo">пользователь создан<br>'+
                'id: '+data.id+' name: '+data.name+' password: '+data.password+' email: '+data.email+'</div>');
        },
        error: function (error) {
            $('#formAddUserJsInfo').remove();
            $('#formAddUserJs').append('<div id="formAddUserJsInfo">неверные данные <br>'+error.responseText+'</div>');
            console.log(error);
        }
    });
}

function delUser() {

    var delUser = $('#formDelUserJs').serialize();

    $.ajax({
        url: 'delUser',
        type: 'post',
        data: delUser,
        dataType: 'json',
        success: function (data) {
            console.log(data);
            $('#formDelUserJsInfo').remove();
            $('#formDelUserJs').append('<div id="formDelUserJsInfo">пользователь удален<br>'+
                'id: '+data.id+' name: '+data.name+' password: '+data.password+' email: '+data.email+'</div>');
        },
        error: function (error) {
            $('#formDelUserJsInfo').remove();
            $('#formDelUserJs').append('<div id="formDelUserJsInfo">неверные данные <br>'+error.responseText+'</div>');
            console.log(error);
        }
    });
}

function addOrder() {

    var addOrder = $('#formAddOrderJs').serialize();

    $.ajax({
        url: 'addOrder',
        type: 'post',
        data: addOrder,
        dataType: 'json',
        success: function (data) {

            $('#formAddOrderJsinfo').remove();

            console.log(data);
            for (var i = 0; i < data.length; i++) {
                $('#formAddOrderJs').append('<div id="formAddOrderJsinfo">заказ добавлен<br>'+
                    'order_id: '+data[i].id+' user_id: '+data[i].user.id+' link: '+data[i].link+' imageUrl: '+data[i].imageUrl+''+
                    'pcs: '+data[i].pcs+' comment: '+data[i].comment+' status: '+data[i].status+' pay: '+data[i].pay+' name: '+data[i].name+'</div><br>');
            }

        },
        error: function (error) {
            $('#formAddOrderJsinfo').remove();
            $('#formAddOrder').append('<div id="formDelUserJsInfo">неверные данные <br>'+error.responseText+'</div>');
            console.log(error);
        }
    });
}

function allUserOrders() {

    var allUserOrders = $('#formGetAllUserOrdersJs').serialize();

    $.ajax({
        url: 'getOrdersByUser',
        type: 'post',
        data: allUserOrders,
        dataType: 'json',
        success: function (data) {

            $('#getAllUserOrdersJsinfo').remove();

            console.log(data);
            for (var i = 0; i < data.length; i++) {
                $('#formGetAllUserOrdersJs').append('<div id="getAllUserOrdersJsinfo">заказ<br>'+
                    'order_id: '+data[i].id+' user_id: '+data[i].user.id+' link: '+data[i].link+' imageUrl: '+data[i].imageUrl+''+
                    'pcs: '+data[i].pcs+' comment: '+data[i].comment+' status: '+data[i].status+' pay: '+data[i].pay+' name: '+data[i].name+'</div><br>');
            }

        },
        error: function (error) {
            $('#getAllUserOrdersJsinfo').remove();
            $('#formGetAllUserOrdersJs').append('<div id="formDelUserJsInfo">неверные данные <br>'+error.responseText+'</div>');
            console.log(error);
        }
    });
}