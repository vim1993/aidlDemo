LOCAL_PATH := $(call my-dir)
include $(CLEAR_VARS)

LOCAL_SRC_FILES := \
    $(call all-subdir-java-files) \
    src/com/app/orange/servicetest/IServiceTestInferface.aidl

LOCAL_MODULE_TAGS := optional

LOCAL_PACKAGE_NAME := orangeServiceTest
ALL_DEFAULT_INSTALLED_MODULES += $(LOCAL_PACKAGE_NAME)
LOCAL_PROGUARD_ENABLED := disabled
LOCAL_CERTIFICATE := platform

include $(BUILD_PACKAGE)