new Vue({
    el:'#app',
    data:{
        see:false
    }

});

new Vue({
	el:'#carList',
	data:{
		cars:[],
		serverUrl: "http://localhost:8090/api/v1"
	},
	methods:{
		getCars:function(){
			var self = this;
			
			axios.get(this.serverUrl + "/cars")
			.then(function(response){
				console.log(response);
				self.cars = response.data;
				
			})
			.catch(function(err){
				console.log(err);
			})
		},
		
	},
	mounted(){
		this.getCars();
	}
	


});