// IServiceTestInferface.aidl
package com.app.orange.servicetest;

// Declare any non-default types here with import statements

import com.app.orange.servicetest.TestInfo;

interface IServiceTestInferface {
    TestInfo getTestInfo();
    void setTestInfo(in TestInfo info);

    boolean setValue(in String key, in String value);
    String getValue(in String key);
}
