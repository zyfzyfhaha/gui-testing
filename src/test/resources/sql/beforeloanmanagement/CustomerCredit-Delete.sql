delete from cls.business_object_process_info where business_object_id in (select id from cls.customer_credit where card_no='@parameter');#
delete from cls.customer_credit_relavant where credit_id in (select id from cls.customer_credit where card_no='@parameter');#
delete from cls.customer_credit where card_no='@parameter'