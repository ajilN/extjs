/*
 * extjspoc.store.Employee
*/

Ext.define('extjspoc.store.Employee', {
    extend: 'Ext.data.Store',
    requires: 'extjspoc.model.Employee',
    model: 'extjspoc.model.Employee',
    proxy: {
		type: 'ajax',
		url: 'rest/employees',
		actionMethods: {
			create: 'POST',
			read: 'GET',
			update: 'POST',
			destroy: 'POST'
		},
		reader: {
			type: 'json',
			root: 'employees'
		}
	},
	autoSync: false,
	autoLoad: false,

    // Event listeners.
    listeners: {
        'beforeload': function(self, operation) {
            console.log('extjspoc.store.Employee beforeload');
            console.log(self, operation);
        },
        'load': function(self, records, successful) {
        	debugger;
        	//var dataAr = Ext.JSON.encode(records);
            console.log('extjspoc.store.Employee load');
            console.log(self, records, successful);
        }
    }
});

//Ext.data.StoreManager.lookup(