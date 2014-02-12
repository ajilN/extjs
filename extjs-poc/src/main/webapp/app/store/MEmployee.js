/*
 * extjspoc.store.MEmployee
*/

Ext.define('extjspoc.store.MEmployee', {
    extend: 'Ext.data.Store',
    requires: 'extjspoc.model.Employee',
    model: 'extjspoc.model.Employee',
    proxy: {
		type: 'memory',
		reader: {
			type: 'json',
			root: 'employee'
		}
	},
	autoSync: false,
	autoLoad: true,

    // Event listeners.
    listeners: {
        'beforeload': function(self, operation) {
            console.log('extjspoc.store.MEmployee beforeload');
            console.log(self, operation);
        },
        'load': function(self, records, successful) {
            console.log('extjspoc.store.MEmployee load');
            console.log(self, records, successful);
        }
    }
});

