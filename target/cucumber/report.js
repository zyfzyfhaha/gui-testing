$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/features/beforeloanmanagement/Step1-CustomerCredit/CustomerCredit.feature");
formatter.feature({
  "comments": [
    {
      "line": 1,
      "value": "#Author: your.email@your.domain.com"
    },
    {
      "line": 2,
      "value": "#Keywords Summary :"
    },
    {
      "line": 3,
      "value": "#Feature: List of scenarios."
    },
    {
      "line": 4,
      "value": "#Scenario: Business rule through list of steps with arguments."
    },
    {
      "line": 5,
      "value": "#Given: Some precondition step"
    },
    {
      "line": 6,
      "value": "#When: Some key actions"
    },
    {
      "line": 7,
      "value": "#Then: To observe outcomes or validation"
    },
    {
      "line": 8,
      "value": "#And,But: To enumerate more Given,When,Then steps"
    },
    {
      "line": 9,
      "value": "#Scenario Outline: List of steps for data-driven as an Examples and \u003cplaceholder\u003e"
    },
    {
      "line": 10,
      "value": "#Examples: Container for s table"
    },
    {
      "line": 11,
      "value": "#Background: List of steps run before each of the scenarios"
    },
    {
      "line": 12,
      "value": "#\"\"\" (Doc Strings)"
    },
    {
      "line": 13,
      "value": "#| (Data Tables)"
    },
    {
      "line": 14,
      "value": "#@ (Tags/Labels):To group Scenarios"
    },
    {
      "line": 15,
      "value": "#\u003c\u003e (placeholder)"
    },
    {
      "line": 16,
      "value": "#\"\""
    },
    {
      "line": 17,
      "value": "## (Comments)"
    },
    {
      "line": 18,
      "value": "#Sample Feature Definition Template"
    },
    {
      "line": 19,
      "value": "#AC1: Normal process with one relavant - spinsterhood"
    }
  ],
  "line": 21,
  "name": "Customer Credit",
  "description": "I want to use this template for my feature file",
  "id": "customer-credit",
  "keyword": "Feature",
  "tags": [
    {
      "line": 20,
      "name": "@test"
    }
  ]
});
formatter.background({
  "line": 24,
  "name": "Login to system",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 25,
  "name": "Login to system for testing CustomerCreidt",
  "rows": [
    {
      "cells": [
        "cardNum"
      ],
      "line": 26
    },
    {
      "cells": [
        "330106198001010013"
      ],
      "line": 27
    }
  ],
  "keyword": "Given "
});
formatter.match({
  "location": "CustomerCreditStepdefs.inti(String,String\u003e\u003e)"
});
formatter.result({
  "duration": 6453411339,
  "status": "passed"
});
formatter.scenario({
  "line": 29,
  "name": "AC1: Normal process with one relavant - spinsterhood",
  "description": "",
  "id": "customer-credit;ac1:-normal-process-with-one-relavant---spinsterhood",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "comments": [
    {
      "line": 30,
      "value": "#Launch Creidt"
    }
  ],
  "line": 31,
  "name": "Navigate to Manage Customer Credit page",
  "keyword": "Given "
});
formatter.step({
  "line": 32,
  "name": "Navigate to LaunchCredit page",
  "keyword": "And "
});
formatter.step({
  "line": 33,
  "name": "Enter customer details in LaunchCredit page",
  "rows": [
    {
      "cells": [
        "customerName",
        "customerIdentify",
        "idNumber",
        "maritalStatus",
        "bank",
        "phoneNumber",
        "guaranteeName",
        "guaranteeCardType",
        "guaranteeIdNum",
        "guaranteePhoneNum",
        "relationship",
        "guaranteeRelationship"
      ],
      "line": 34
    },
    {
      "cells": [
        "uiTest001",
        "身份证",
        "330106198001010013",
        "未婚",
        "Automation Bank",
        "15868470001",
        "uiTest002",
        "身份证",
        "110101198001010010",
        "15868470002",
        "父亲",
        "担保人"
      ],
      "line": 35
    }
  ],
  "keyword": "And "
});
formatter.step({
  "line": 36,
  "name": "Click the submit button",
  "keyword": "When "
});
formatter.step({
  "line": 37,
  "name": "Click the confirm YES button",
  "keyword": "Then "
});
formatter.step({
  "line": 38,
  "name": "Select a submitter",
  "rows": [
    {
      "cells": [
        "submmiter"
      ],
      "line": 39
    },
    {
      "cells": [
        "朱云峰"
      ],
      "line": 40
    }
  ],
  "keyword": "And "
});
formatter.step({
  "line": 41,
  "name": "Click the Final Confirm button",
  "keyword": "And "
});
formatter.step({
  "comments": [
    {
      "line": 42,
      "value": "#Normal Process"
    }
  ],
  "line": 43,
  "name": "Click My Task panel",
  "keyword": "Given "
});
formatter.step({
  "line": 44,
  "name": "Click My Task button",
  "keyword": "And "
});
formatter.step({
  "line": 45,
  "name": "Find my client",
  "rows": [
    {
      "cells": [
        "customerName",
        "processName"
      ],
      "line": 46
    },
    {
      "cells": [
        "uiTest001",
        "征信流程"
      ],
      "line": 47
    }
  ],
  "keyword": "And "
});
formatter.step({
  "line": 48,
  "name": "Click the operation button",
  "keyword": "And "
});
formatter.step({
  "comments": [
    {
      "line": 49,
      "value": "#Enter Creidt"
    }
  ],
  "line": 50,
  "name": "Enter details in EnterCredit page",
  "rows": [
    {
      "cells": [
        "customerResearchType",
        "customerResearchResult",
        "customerRemark",
        "relavantResearchType",
        "relavantResearchResult",
        "relavantRemark"
      ],
      "line": 51
    },
    {
      "cells": [
        "电话",
        "通过",
        "客户测试备注",
        "电话",
        "通过",
        "担保人测试备注"
      ],
      "line": 52
    }
  ],
  "keyword": "And "
});
formatter.step({
  "line": 53,
  "name": "Click the submit button",
  "keyword": "When "
});
formatter.step({
  "line": 54,
  "name": "Click the confirm YES button",
  "keyword": "Then "
});
formatter.step({
  "comments": [
    {
      "line": 55,
      "value": "#Normal Process"
    }
  ],
  "line": 56,
  "name": "Click My Task panel",
  "keyword": "Given "
});
formatter.step({
  "line": 57,
  "name": "Click My Task button",
  "keyword": "And "
});
formatter.step({
  "line": 58,
  "name": "Find my client",
  "rows": [
    {
      "cells": [
        "customerName",
        "processName"
      ],
      "line": 59
    },
    {
      "cells": [
        "uiTest001",
        "征信流程"
      ],
      "line": 60
    }
  ],
  "keyword": "And "
});
formatter.step({
  "line": 61,
  "name": "Click the operation button",
  "keyword": "And "
});
formatter.step({
  "comments": [
    {
      "line": 62,
      "value": "#Accept Creidt"
    }
  ],
  "line": 63,
  "name": "Click the submit button",
  "keyword": "When "
});
formatter.step({
  "line": 64,
  "name": "Click the confirm YES button",
  "keyword": "Then "
});
formatter.step({
  "line": 65,
  "name": "Check if customer credit successfully",
  "rows": [
    {
      "cells": [
        "customerName",
        "idNumber",
        "creditResult"
      ],
      "line": 66
    },
    {
      "cells": [
        "uiTest001",
        "330106198001010013",
        "征信通过"
      ],
      "line": 67
    }
  ],
  "keyword": "Then "
});
formatter.match({
  "location": "CustomerCreditStepdefs.navigateToCustomerCreditPage()"
});
formatter.result({
  "duration": 4627409887,
  "status": "passed"
});
formatter.match({
  "location": "CustomerCreditStepdefs.navigateToLaunchCreditPage()"
});
formatter.result({
  "duration": 269039811,
  "status": "passed"
});
formatter.match({
  "location": "CustomerCreditStepdefs.enterCustomerDetailsInLaunchCreditPage(String,String\u003e\u003e)"
});
formatter.result({
  "duration": 502067171,
  "error_message": "org.openqa.selenium.NoSuchElementException: Cannot locate element with text: Automation Bank\nFor documentation on this error, please visit: http://seleniumhq.org/exceptions/no_such_element.html\nBuild info: version: \u00272.48.2\u0027, revision: \u002741bccdd\u0027, time: \u00272015-10-09 19:55:52\u0027\nSystem info: host: \u0027cheguo-PC\u0027, ip: \u002710.10.13.118\u0027, os.name: \u0027Windows 7\u0027, os.arch: \u0027amd64\u0027, os.version: \u00276.1\u0027, java.version: \u00271.8.0_65\u0027\nDriver info: driver.version: unknown\r\n\tat org.openqa.selenium.support.ui.Select.selectByVisibleText(Select.java:150)\r\n\tat cls.ui.model.selenium.customercredit.LaunchCreditPage.selectBank(LaunchCreditPage.java:104)\r\n\tat cls.ui.application.beforeloan.CustomerCreditStepdefs.enterCustomerDetailsInLaunchCreditPage(CustomerCreditStepdefs.java:88)\r\n\tat ✽.And Enter customer details in LaunchCredit page(src/test/resources/features/beforeloanmanagement/Step1-CustomerCredit/CustomerCredit.feature:33)\r\n",
  "status": "failed"
});
formatter.match({
  "location": "CustomerCreditStepdefs.clickSubmitButton()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "CustomerCreditStepdefs.clickConfirmYesButton()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "CustomerCreditStepdefs.selectSubmitter(String,String\u003e\u003e)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "CustomerCreditStepdefs.clickConfirmButton()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "CustomerCreditStepdefs.clickMyTaskPanel()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "CustomerCreditStepdefs.clickMyTaskButton()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "CustomerCreditStepdefs.findMyClient(String,String\u003e\u003e)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "CustomerCreditStepdefs.click_the_operation_Start_Credit()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "CustomerCreditStepdefs.enter_details_in_EnterCredit_page(String,String\u003e\u003e)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "CustomerCreditStepdefs.clickSubmitButton()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "CustomerCreditStepdefs.clickConfirmYesButton()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "CustomerCreditStepdefs.clickMyTaskPanel()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "CustomerCreditStepdefs.clickMyTaskButton()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "CustomerCreditStepdefs.findMyClient(String,String\u003e\u003e)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "CustomerCreditStepdefs.click_the_operation_Start_Credit()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "CustomerCreditStepdefs.clickSubmitButton()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "CustomerCreditStepdefs.clickConfirmYesButton()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "CustomerCreditStepdefs.Check_if_customer_credit_successfully(String,String\u003e\u003e)"
});
formatter.result({
  "status": "skipped"
});
});