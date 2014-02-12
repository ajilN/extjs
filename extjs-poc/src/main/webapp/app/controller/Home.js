Ext.define('extjspoc.controller.Home', {
     extend:'Ext.app.Controller',
     stores: [
      		'Employee'
     ],
     views: [
     		'extjspoc.view.Home',
     		'extjspoc.view.ModalEmployee',
     		'extjspoc.view.ModalForm'
     ],
     init:function(){
          this.control({
               //Component listeners
          });

          this.application.on({
               //Event handlers
          });
     }
});