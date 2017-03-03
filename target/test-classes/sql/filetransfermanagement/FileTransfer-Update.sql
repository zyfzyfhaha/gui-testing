update document_deliver set deliver_status=1 where project_id='@parameter';#
delete from business_object_process_info where business_object_id in (select id from document_deliver where project_id='@parameter') and business_type='DOCUMENT_TRANSMIT_FLOW' and flow_index in (3,4,5);#
update business_object_process_info set is_finished=0 where business_object_id in (select id from document_deliver where project_id='@parameter') and business_type='DOCUMENT_TRANSMIT_FLOW';#
update business_object_process_info set is_submitted=0 where business_object_id in (select id from document_deliver where project_id='@parameter') and business_type='DOCUMENT_TRANSMIT_FLOW' and flow_index=2;#
update business_object_process_status set flow_status=4 where business_object_id in (select id from document_deliver where project_id='@parameter') and business_type_key='DOCUMENT_TRANSMIT_FLOW';#
delete from document_deliver_customer where project_id='@parameter';#
delete from document_deliver_guarantor where project_id='@parameter'