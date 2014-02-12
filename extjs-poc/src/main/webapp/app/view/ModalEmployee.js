Ext.define("extjspoc.view.ModalEmployee", {
	extend: 'Ext.window.Window',
	alias: ['widget.modalemployee'],
	id:'modalemployee-window',
	title: 'Employee Info',
    height: 300,
    width: 400,
    layout: 'fit',
    modal :true,
    items: [{
        xtype: 'modalForm',
        id:'emp-modal-form'
    }],
    buttons: [{
    	 text: 'Update',
    	 handler: function() {
    		 debugger;
    		 Ext.getCmp('emp-modal-form').updateRecord();
    		 var record = Ext.getCmp('emp-modal-form').getRecord();
    		 Ext.Ajax.request({
					url: 'rest/employee/save',
					method: 'POST',
					scope: this,
					jsonData: Ext.JSON.encode(record.data),
					success: function(response, opts) {
						 Ext.getCmp('modalemployee-window').close();
			    		 Ext.getCmp('employee-grid').getView().refresh();
					},
					failure: function(response, opts) {
						console.log('rest/employee/save', response);
					}
				});
    		 /*Ext.getCmp('modalemployee-window').close();
    		 Ext.getCmp('employee-grid').getView().refresh();*/
    		// Ext.getStore('Employee').sync();
    	 }
    }]
});