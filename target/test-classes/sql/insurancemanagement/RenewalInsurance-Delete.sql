delete from loan_insurance_renewal_info_detail where loan_insurance_id in (select id from loan_insurance_renewal_info where project_id = '@parameter');#
delete from loan_insurance_renewal_info where project_id = '@parameter';#
delete from loan_insurance_renewal_info_phone where project_id = '@parameter'
