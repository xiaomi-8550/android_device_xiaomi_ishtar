#
# Copyright (C) 2024 Paranoid Android
#
# SPDX-License-Identifier: Apache-2.0
#

# Inherit from sm8550-common
$(call inherit-product, device/xiaomi/sm8550-common/common.mk)

# Get non-open-source specific aspects
$(call inherit-product, vendor/xiaomi/ishtar/ishtar-vendor.mk)

# Soong namespaces
PRODUCT_SOONG_NAMESPACES += \
    $(LOCAL_PATH)

# Kernel Binary
KERNEL_PREBUILT_DIR := device/xiaomi/ishtar-kernel

# NFC
TARGET_USES_ST_NFC := true

# Overlays
PRODUCT_PACKAGES += \
    IshtarFrameworks \
    IshtarSettings2304FPN6DC \
    IshtarSettings2304FPN6DG \
    IshtarSettingsProvider \
    IshtarSystemUI \
    IshtarWifiRes \
    IshtarWifiResMainline \

# Parts
PRODUCT_PACKAGES += \
    XiaomiIshtarParts

# Sensors
PRODUCT_COPY_FILES += \
    frameworks/native/data/etc/android.hardware.sensor.barometer.xml:$(TARGET_COPY_OUT_VENDOR)/etc/permissions/android.hardware.sensor.barometer.xml
