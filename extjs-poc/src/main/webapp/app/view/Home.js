

/*var storeEmp = new Ext.data.Store({ 
    fields:['name','email','phone','place','status','state'],
    proxy: {
        type: 'ajax',
        url : 'rest/employees',
        reader: {
            type: 'json',
            root: 'employees'
        }
    },
    autoLoad : true
});*/


/*Ext.create('Ext.data.Store', {
    storeId:'simpsonsStore',
    fields:['name', 'email', 'phone' , 'place' , 'status', 'state'],
    data:{'items':[
        { "employeeId":9888,"name":"ajil","place":"thrissur","status":"Act","state":"kerala","email":"ajil@test.com","phone":"568974123"},
        { "employeeId":9888,"name":"jay","place":"thrissur","status":"Act","state":"kerala","email":"jay@test.com","phone":"568974123"},
        { "employeeId":9888,"name":"jay","place":"thrissur","status":"Act","state":"kerala","email":"jay@test.com","phone":"568974123"},
        { "employeeId":9888,"name":"jay","place":"thrissur","status":"Act","state":"kerala","email":"jay@test.com","phone":"568974123"}
    ]},
    proxy: {
        type: 'memory',
        reader: {
            type: 'json',
            root: 'employees'
        }
    }
});*/

//{"employees":[{"employeeId":9888,"name":"ajil","place":"thrissur","status":"Act","state":"kerala","email":"ajil@test.com","phone":"568974123"},{"employeeId":9888,"name":"jay","place":"thrissur","status":"Act","state":"kerala","email":"jay@test.com","phone":"568974123"}]}

Ext.define("extjspoc.view.Home", {
	extend: 'Ext.grid.Panel',
	alias: ['widget.home'],
	id:'employee-grid',
	layout: {
	    type: 'border',
	    padding: 5
	},
	store: 'Employee',
	title: 'Employee List76',
    height: 200,
    width: 300,
    listeners: {
    	select : function (ths, record, index, eOpts) {
    		var emStore = Ext.getStore('Employee');
    		//emStore.loadData(record.data);
    		 //this.getStockForm().getForm().loadRecord(record.data);
    		var empMpdal = Ext.create('extjspoc.view.ModalEmployee'); 
    		//Ext.getCmp('emp-modal-form').loadRecord(record.data);
    		Ext.getCmp('emp-modal-form').loadRecord(emStore.getAt(index)); 
    		empMpdal.show();
    		
    	}
    },
  /*  *//**
     * Override.
     *//*
    setRootNode: function() {
        if (this.getStore().autoLoad) {
            this.callParent(arguments);
        }
    },*/
    initComponent: function(){
    	var st = Ext.getStore('Employee');
        st.load({
            callback: function(records, opertion, success) {
                console.log("in load....."+records[0].get('name'));
            },
        });

        console.log(" count " + st.getCount());
        this.columns = [
            {header: 'Name',  dataIndex: 'name'},
            { header: 'Email', dataIndex: 'email', flex: 1 },
            { header: 'Phone', dataIndex: 'phone' },
            { header: 'Place', dataIndex: 'place' },
            { header: 'Status', dataIndex: 'status' },
            { header: 'State', dataIndex: 'state' }
        ];

        this.callParent(arguments);
    }
	
	/*,
    initComponent: function(){
        this.callParent();
        this.on('render', this.loadStore, this);
    },
    loadStore: function() {
    	debugger;
        this.getStore().load();
    }*/
});