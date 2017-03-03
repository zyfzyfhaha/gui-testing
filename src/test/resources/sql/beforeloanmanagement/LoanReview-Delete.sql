DELETE FROM cls.loan_project_info WHERE apply_Id = '@parameter' ;#
DELETE FROM cls.loan_customer_info WHERE apply_Id = '@parameter' ;#
DELETE FROM cls.loan_customer_contacter WHERE apply_Id = '@parameter' ;#
DELETE FROM cls.loan_fee_info WHERE apply_Id = '@parameter' ;#
DELETE FROM cls.loan_guarantor_info WHERE apply_Id = '@parameter' ;#
DELETE FROM cls.loan_assets_info WHERE apply_Id = '@parameter' ;#
DELETE FROM cls.loan_payment_info WHERE apply_Id = '@parameter' ;#
DELETE FROM cls.loan_document WHERE object_type = 'loan' AND object_no IN (SELECT project_id FROM cls.loan_apply WHERE id = '@parameter') ;#
DELETE cls.loan_approve_project FROM cls.loan_approve_project INNER JOIN cls.loan_apply ON loan_approve_project.project_id = loan_apply.project_id WHERE loan_apply.flow_type = 'LOAN_APPLY_FLOW' AND loan_apply.id = '@parameter' ;#
DELETE cls.loan_approve_customer FROM cls.loan_approve_customer INNER JOIN cls.loan_apply ON loan_approve_customer.project_id = loan_apply.project_id WHERE loan_apply.flow_type = 'LOAN_APPLY_FLOW' AND loan_apply.id = '@parameter' ;#
DELETE cls.loan_approve_contacter FROM cls.loan_approve_contacter INNER JOIN cls.loan_apply ON loan_approve_contacter.project_id = loan_apply.project_id WHERE loan_apply.flow_type = 'LOAN_APPLY_FLOW' AND loan_apply.id = '@parameter' ;#
DELETE cls.loan_approve_fee FROM cls.loan_approve_fee INNER JOIN cls.loan_apply ON loan_approve_fee.project_id = loan_apply.project_id WHERE loan_apply.flow_type = 'LOAN_APPLY_FLOW' AND loan_apply.id = '@parameter' ;#
DELETE cls.loan_approve_guarantor FROM cls.loan_approve_guarantor INNER JOIN cls.loan_apply ON loan_approve_guarantor.project_id = loan_apply.project_id WHERE loan_apply.flow_type = 'LOAN_APPLY_FLOW' AND loan_apply.id = '@parameter' ;#
DELETE cls.loan_approve_assets FROM cls.loan_approve_assets INNER JOIN cls.loan_apply ON loan_approve_assets.project_id = loan_apply.project_id WHERE loan_apply.flow_type = 'LOAN_APPLY_FLOW' AND loan_apply.id = '@parameter' ;#
DELETE cls.loan_approve_payment FROM cls.loan_approve_payment INNER JOIN cls.loan_apply ON loan_approve_payment.project_id = loan_apply.project_id WHERE loan_apply.flow_type = 'LOAN_APPLY_FLOW' AND loan_apply.id = '@parameter' ;#
UPDATE loan_approve_project SET relative_apply_id2 = (SELECT MAX(id) FROM loan_apply WHERE project_id = loan_approve_project.project_id AND STATUS = 2 AND relative_apply_id IS NOT NULL), flow_type = 'LOAN_APPLY_FLOW',node_key = 'LOAN_BRANCH_CASHIER' WHERE project_id IN (SELECT project_id FROM cls.loan_apply WHERE id = '@parameter') ;#
DELETE FROM cls.business_object_process_info WHERE business_type IN ('LOAN_APPLY_FLOW','LOAN_MODIFY_FLOW','LOAN_CANCEL_FLOW') AND business_object_id IN (SELECT id FROM cls.loan_apply WHERE id = '@parameter') ;#
DELETE FROM cls.loan_apply WHERE id = '@parameter'