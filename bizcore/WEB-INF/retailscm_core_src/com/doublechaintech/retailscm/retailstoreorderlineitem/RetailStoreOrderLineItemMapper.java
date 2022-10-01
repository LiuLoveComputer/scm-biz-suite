package com.doublechaintech.retailscm.retailstoreorderlineitem;

import com.doublechaintech.retailscm.Beans;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.BaseRowMapper;
import com.doublechaintech.retailscm.retailstoreorder.RetailStoreOrder;

public class RetailStoreOrderLineItemMapper extends BaseRowMapper<RetailStoreOrderLineItem> {

  public static RetailStoreOrderLineItemMapper mapperForClass(Class<?> clazz) {

    RetailStoreOrderLineItemMapper mapperForOverride = new RetailStoreOrderLineItemMapper();
    mapperForOverride.setClazz(clazz);
    return mapperForOverride;
  }

  protected RetailStoreOrderLineItem internalMapRow(ResultSet rs, int rowNumber)
      throws SQLException {
    RetailStoreOrderLineItem retailStoreOrderLineItem = getRetailStoreOrderLineItem();

    setId(retailStoreOrderLineItem, rs, rowNumber);
    setBizOrder(retailStoreOrderLineItem, rs, rowNumber);
    setSkuId(retailStoreOrderLineItem, rs, rowNumber);
    setSkuName(retailStoreOrderLineItem, rs, rowNumber);
    setAmount(retailStoreOrderLineItem, rs, rowNumber);
    setQuantity(retailStoreOrderLineItem, rs, rowNumber);
    setUnitOfMeasurement(retailStoreOrderLineItem, rs, rowNumber);
    setVersion(retailStoreOrderLineItem, rs, rowNumber);

    return retailStoreOrderLineItem;
  }

  protected RetailStoreOrderLineItem getRetailStoreOrderLineItem() {
    if (null == clazz) {

      RetailStoreOrderLineItem entity = new RetailStoreOrderLineItem();

      Beans.dbUtil().markEnhanced(entity);
      return entity;
    }
    return super.constructFromClass();
  }

  protected void setId(
      RetailStoreOrderLineItem retailStoreOrderLineItem, ResultSet rs, int rowNumber)
      throws SQLException {
    try {
      // there will be issue when the type is double/int/long

      String id = rs.getString(RetailStoreOrderLineItemTable.COLUMN_ID);

      if (id == null) {
        // do nothing when nothing found in database
        return;
      }

      retailStoreOrderLineItem.setId(id);
    } catch (SQLException e) {

    }
  }

  protected void setBizOrder(
      RetailStoreOrderLineItem retailStoreOrderLineItem, ResultSet rs, int rowNumber)
      throws SQLException {
    String retailStoreOrderId;
    try {
      retailStoreOrderId = rs.getString(RetailStoreOrderLineItemTable.COLUMN_BIZ_ORDER);
    } catch (SQLException e) {
      return;
    }
    if (retailStoreOrderId == null) {
      return;
    }
    if (retailStoreOrderId.isEmpty()) {
      return;
    }
    RetailStoreOrder retailStoreOrder = retailStoreOrderLineItem.getBizOrder();
    if (retailStoreOrder != null) {
      // if the root object 'retailStoreOrderLineItem' already have the property, just set the id
      // for it;
      retailStoreOrder.setId(retailStoreOrderId);

      return;
    }
    retailStoreOrderLineItem.setBizOrder(createEmptyBizOrder(retailStoreOrderId));
  }

  protected void setSkuId(
      RetailStoreOrderLineItem retailStoreOrderLineItem, ResultSet rs, int rowNumber)
      throws SQLException {
    try {
      // there will be issue when the type is double/int/long

      String skuId = rs.getString(RetailStoreOrderLineItemTable.COLUMN_SKU_ID);

      if (skuId == null) {
        // do nothing when nothing found in database
        return;
      }

      retailStoreOrderLineItem.setSkuId(skuId);
    } catch (SQLException e) {

    }
  }

  protected void setSkuName(
      RetailStoreOrderLineItem retailStoreOrderLineItem, ResultSet rs, int rowNumber)
      throws SQLException {
    try {
      // there will be issue when the type is double/int/long

      String skuName = rs.getString(RetailStoreOrderLineItemTable.COLUMN_SKU_NAME);

      if (skuName == null) {
        // do nothing when nothing found in database
        return;
      }

      retailStoreOrderLineItem.setSkuName(skuName);
    } catch (SQLException e) {

    }
  }

  protected void setAmount(
      RetailStoreOrderLineItem retailStoreOrderLineItem, ResultSet rs, int rowNumber)
      throws SQLException {
    try {
      // there will be issue when the type is double/int/long

      BigDecimal amount = rs.getBigDecimal(RetailStoreOrderLineItemTable.COLUMN_AMOUNT);

      if (amount == null) {
        // do nothing when nothing found in database
        return;
      }

      retailStoreOrderLineItem.setAmount(amount);
    } catch (SQLException e) {

    }
  }

  protected void setQuantity(
      RetailStoreOrderLineItem retailStoreOrderLineItem, ResultSet rs, int rowNumber)
      throws SQLException {
    try {
      // there will be issue when the type is double/int/long

      Integer quantity = rs.getInt(RetailStoreOrderLineItemTable.COLUMN_QUANTITY);

      if (quantity == null) {
        // do nothing when nothing found in database
        return;
      }

      retailStoreOrderLineItem.setQuantity(quantity);
    } catch (SQLException e) {

    }
  }

  protected void setUnitOfMeasurement(
      RetailStoreOrderLineItem retailStoreOrderLineItem, ResultSet rs, int rowNumber)
      throws SQLException {
    try {
      // there will be issue when the type is double/int/long

      String unitOfMeasurement =
          rs.getString(RetailStoreOrderLineItemTable.COLUMN_UNIT_OF_MEASUREMENT);

      if (unitOfMeasurement == null) {
        // do nothing when nothing found in database
        return;
      }

      retailStoreOrderLineItem.setUnitOfMeasurement(unitOfMeasurement);
    } catch (SQLException e) {

    }
  }

  protected void setVersion(
      RetailStoreOrderLineItem retailStoreOrderLineItem, ResultSet rs, int rowNumber)
      throws SQLException {
    try {
      // there will be issue when the type is double/int/long

      Integer version = rs.getInt(RetailStoreOrderLineItemTable.COLUMN_VERSION);

      if (version == null) {
        // do nothing when nothing found in database
        return;
      }

      retailStoreOrderLineItem.setVersion(version);
    } catch (SQLException e) {

    }
  }

  protected RetailStoreOrder createEmptyBizOrder(String retailStoreOrderId) {

    RetailStoreOrder retailStoreOrder = new RetailStoreOrder();

    retailStoreOrder.setId(retailStoreOrderId);
    retailStoreOrder.setVersion(Integer.MAX_VALUE);
    return retailStoreOrder;
  }
}
