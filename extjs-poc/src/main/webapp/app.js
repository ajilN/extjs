// Setup Loader config
Ext.Loader.setConfig({
	disableCaching: false,
	enabled: true,
	paths: {
		'extjspoc': 'app'
	}
});

Ext.Loader.require([
            		'extjspoc.store.Employee'
]);

Ext.application({
        name:'extjspoc',
		appFolder: 'app',
		autoCreateViewport: false,
		
		
		// All modals in app/modals/.
		models: [
		         'Employee'    
		],
		
		// All stores in app/stores/.
		stores: [
		         'Employee'
		],
		
		controllers:['Home'
		],
		     		
		
        launch:function(){
            console.log('App created');
			
			var homePnale = Ext.create('extjspoc.view.Home'); 

            Ext.create('Ext.container.Viewport',{
                layout:'fit',
                width:'50%',
                items:[homePnale]
            });
        }
});