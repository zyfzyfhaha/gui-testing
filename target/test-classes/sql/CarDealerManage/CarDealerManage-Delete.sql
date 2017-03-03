delete from cls.business_object_process_status where business_object_id in (select id from cls.car_dealer_info where dealer_name='@parameter') and business_type_key='CAR_DEALER_ADD_FLOW';#
delete from cls.business_object_process_info where borrower_id in (select id from cls.car_dealer_info where dealer_name='@parameter') and business_type='CAR_DEALER_ADD_FLOW';#
delete from cls.car_manage_team_member where car_dealer_id in (select id from cls.car_dealer_info where dealer_name='@parameter');#
delete from cls.car_dealer_account where dealer_id in (select id from cls.car_dealer_info where dealer_name='@parameter');#
delete from cls.car_fee_info where car_dealer_id in (select id from cls.car_dealer_info where dealer_name='@parameter');#
delete from cls.car_dealer_info where dealer_name='@parameter'
