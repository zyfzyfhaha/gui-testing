delete from business_object_process_info where business_object_id in (select id from document_deliver where project_id='@parameter') and business_type='DOCUMENT_TRANSMIT_FLOW';#
delete from business_object_process_status where business_object_id in (select id from document_deliver where project_id='@parameter') and business_type_key='DOCUMENT_TRANSMIT_FLOW';#
delete from document_deliver_list where document_deliver_id in (select id from document_deliver where project_id='@parameter');#
delete from document_deliver where project_id='@parameter';#
delete from document_deliver_customer where project_id='@parameter';#
delete from document_deliver_guarantor where project_id='@parameter';#
delete from document_deliver_express_bill where id in (select bill_id from document_deliver_express_bill_list where project_id = '@parameter');#
delete from document_deliver_express_bill_list where project_id = '@parameter'