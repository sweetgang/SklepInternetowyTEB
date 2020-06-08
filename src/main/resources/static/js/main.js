var messageApi = Vue.resource('/sell_item{/kodProduktu}')

Vue.component('message-row',{
    props:'message',
    template:'<div><i>{{message.id}}</i><i>{{message.name}}</i>{{message.kodProductu}}</div>'
})
Vue.component('meseges-list', {
    props:'messages',
    template: '<div.<message-row v-for="message in messages" :key="message.id" :message="message"/></div>',
    created: function () {
       messageApi.get().then(result =>
          console.log(result)
       )
    }
});
var app = new Vue({
    el: '#app',
    template: '<meseges-list :messages="messages"/>',
    data: {
        messages: [

        ]
    }
});