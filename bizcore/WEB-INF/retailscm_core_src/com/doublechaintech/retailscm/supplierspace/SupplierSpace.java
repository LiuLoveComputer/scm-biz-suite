package com.doublechaintech.retailscm.supplierspace;

import java.util.*;
import java.util.stream.Collectors;
import java.math.BigDecimal;
import com.terapico.caf.*;
import com.doublechaintech.retailscm.search.*;
import com.doublechaintech.retailscm.*;
import com.doublechaintech.retailscm.utils.*;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.terapico.caf.baseelement.MemberMetaInfo;
import com.doublechaintech.retailscm.warehouse.Warehouse;
import com.doublechaintech.retailscm.goodsshelf.GoodsShelf;

@JsonSerialize(using = SupplierSpaceSerializer.class)
public class SupplierSpace extends BaseEntity implements java.io.Serializable {

  public void transferAllRelationshipsTo(SupplierSpace target) {
    if (target == null) {
      return;
    }
    target.addGoodsShelfList(this.getGoodsShelfList());
  }

  public static final String ID_PROPERTY = "id";
  public static final String LOCATION_PROPERTY = "location";
  public static final String CONTACT_NUMBER_PROPERTY = "contactNumber";
  public static final String TOTAL_AREA_PROPERTY = "totalArea";
  public static final String WAREHOUSE_PROPERTY = "warehouse";
  public static final String LATITUDE_PROPERTY = "latitude";
  public static final String LONGITUDE_PROPERTY = "longitude";
  public static final String LAST_UPDATE_TIME_PROPERTY = "lastUpdateTime";
  public static final String VERSION_PROPERTY = "version";

  public static final String GOODS_SHELF_LIST = "goodsShelfList";

  public static final String INTERNAL_TYPE = "SupplierSpace";

  public String getInternalType() {
    return INTERNAL_TYPE;
  }

  protected static List<MemberMetaInfo> memberMetaInfoList = new ArrayList<>();

  static {
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(ID_PROPERTY, "id", "ID").withType("id", String.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(LOCATION_PROPERTY, "location", "位置")
            .withType("string", String.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(CONTACT_NUMBER_PROPERTY, "contact_number", "联系电话")
            .withType("string", String.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(TOTAL_AREA_PROPERTY, "total_area", "总面积")
            .withType("string", String.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(WAREHOUSE_PROPERTY, "warehouse", "仓库")
            .withType("warehouse", Warehouse.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(LATITUDE_PROPERTY, "latitude", "纬度")
            .withType("double", "BigDecimal"));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(LONGITUDE_PROPERTY, "longitude", "经度")
            .withType("double", "BigDecimal"));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(LAST_UPDATE_TIME_PROPERTY, "last_update_time", "更新于")
            .withType("date_time_update", DateTime.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(VERSION_PROPERTY, "version", "版本").withType("version", "int"));

    memberMetaInfoList.add(
        MemberMetaInfo.referBy(GOODS_SHELF_LIST, "supplierSpace", "货架列表")
            .withType("goods_shelf", GoodsShelf.class));
  }

  public List<MemberMetaInfo> getMemberMetaInfoList() {
    return memberMetaInfoList;
  }

  public String[] getPropertyNames() {
    return new String[] {
      ID_PROPERTY,
      LOCATION_PROPERTY,
      CONTACT_NUMBER_PROPERTY,
      TOTAL_AREA_PROPERTY,
      WAREHOUSE_PROPERTY,
      LATITUDE_PROPERTY,
      LONGITUDE_PROPERTY,
      LAST_UPDATE_TIME_PROPERTY,
      VERSION_PROPERTY
    };
  }

  public Map<String, String> getReferProperties() {
    Map<String, String> refers = new HashMap<>();

    refers.put(GOODS_SHELF_LIST, "supplierSpace");

    return refers;
  }

  public Map<String, Class> getReferTypes() {
    Map<String, Class> refers = new HashMap<>();

    refers.put(GOODS_SHELF_LIST, GoodsShelf.class);

    return refers;
  }

  public Map<String, Class<? extends BaseEntity>> getParentProperties() {
    Map<String, Class<? extends BaseEntity>> parents = new HashMap<>();
    parents.put(WAREHOUSE_PROPERTY, Warehouse.class);

    return parents;
  }
  /*
  public SupplierSpace want(Class<? extends BaseEntity>... classes) {
      doWant(classes);
      return this;
    }

  public SupplierSpace wants(Class<? extends BaseEntity>... classes) {
    doWants(classes);
    return this;
  }*/

  public String getDisplayName() {

    String displayName = getLocation();
    if (displayName != null) {
      return displayName;
    }

    return super.getDisplayName();
  }

  private static final long serialVersionUID = 1L;

  protected String id;
  protected String location;
  protected String contactNumber;
  protected String totalArea;
  protected Warehouse warehouse;
  protected BigDecimal latitude;
  protected BigDecimal longitude;
  protected DateTime lastUpdateTime;
  protected int version;

  protected SmartList<GoodsShelf> mGoodsShelfList;

  public SupplierSpace() {
    // lazy load for all the properties
  }

  public static SupplierSpace withId(String id) {
    SupplierSpace supplierSpace = new SupplierSpace();
    supplierSpace.setId(id);
    supplierSpace.setVersion(Integer.MAX_VALUE);
    supplierSpace.setChecked(true);
    return supplierSpace;
  }

  public static SupplierSpace refById(String id) {
    return withId(id);
  }

  public SupplierSpace limit(int count) {
    doAddLimit(0, count);
    return this;
  }

  public SupplierSpace limit(int start, int count) {
    doAddLimit(start, count);
    return this;
  }

  public static SupplierSpace searchExample() {
    SupplierSpace supplierSpace = new SupplierSpace();
    supplierSpace.setVersion(UNSET_INT);

    return supplierSpace;
  }

  // disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
  /*
  public 	void clearFromAll(){
  	setWarehouse( null );

  	this.changed = true;
  	setChecked(false);
  }  */

  // Support for changing the property

  public void changeProperty(String property, String newValueExpr) {

    if (LOCATION_PROPERTY.equals(property)) {
      changeLocationProperty(newValueExpr);
    }
    if (CONTACT_NUMBER_PROPERTY.equals(property)) {
      changeContactNumberProperty(newValueExpr);
    }
    if (TOTAL_AREA_PROPERTY.equals(property)) {
      changeTotalAreaProperty(newValueExpr);
    }
    if (LATITUDE_PROPERTY.equals(property)) {
      changeLatitudeProperty(newValueExpr);
    }
    if (LONGITUDE_PROPERTY.equals(property)) {
      changeLongitudeProperty(newValueExpr);
    }
    if (LAST_UPDATE_TIME_PROPERTY.equals(property)) {
      changeLastUpdateTimeProperty(newValueExpr);
    }
  }

  protected void changeLocationProperty(String newValueExpr) {

    String oldValue = getLocation();
    String newValue = parseString(newValueExpr);
    if (equalsString(oldValue, newValue)) {
      return; // they can be both null, or exact the same object, this is much faster than equals
              // function
    }
    // they are surely different each other
    updateLocation(newValue);
    this.onChangeProperty(LOCATION_PROPERTY, oldValue, newValue);
    return;
  }

  protected void changeContactNumberProperty(String newValueExpr) {

    String oldValue = getContactNumber();
    String newValue = parseString(newValueExpr);
    if (equalsString(oldValue, newValue)) {
      return; // they can be both null, or exact the same object, this is much faster than equals
              // function
    }
    // they are surely different each other
    updateContactNumber(newValue);
    this.onChangeProperty(CONTACT_NUMBER_PROPERTY, oldValue, newValue);
    return;
  }

  protected void changeTotalAreaProperty(String newValueExpr) {

    String oldValue = getTotalArea();
    String newValue = parseString(newValueExpr);
    if (equalsString(oldValue, newValue)) {
      return; // they can be both null, or exact the same object, this is much faster than equals
              // function
    }
    // they are surely different each other
    updateTotalArea(newValue);
    this.onChangeProperty(TOTAL_AREA_PROPERTY, oldValue, newValue);
    return;
  }

  protected void changeLatitudeProperty(String newValueExpr) {

    BigDecimal oldValue = getLatitude();
    BigDecimal newValue = parseBigDecimal(newValueExpr);
    if (equalsBigDecimal(oldValue, newValue)) {
      return; // they can be both null, or exact the same object, this is much faster than equals
              // function
    }
    // they are surely different each other
    updateLatitude(newValue);
    this.onChangeProperty(LATITUDE_PROPERTY, oldValue, newValue);
    return;
  }

  protected void changeLongitudeProperty(String newValueExpr) {

    BigDecimal oldValue = getLongitude();
    BigDecimal newValue = parseBigDecimal(newValueExpr);
    if (equalsBigDecimal(oldValue, newValue)) {
      return; // they can be both null, or exact the same object, this is much faster than equals
              // function
    }
    // they are surely different each other
    updateLongitude(newValue);
    this.onChangeProperty(LONGITUDE_PROPERTY, oldValue, newValue);
    return;
  }

  protected void changeLastUpdateTimeProperty(String newValueExpr) {

    DateTime oldValue = getLastUpdateTime();
    DateTime newValue = parseTimestamp(newValueExpr);
    if (equalsTimestamp(oldValue, newValue)) {
      return; // they can be both null, or exact the same object, this is much faster than equals
              // function
    }
    // they are surely different each other
    updateLastUpdateTime(newValue);
    this.onChangeProperty(LAST_UPDATE_TIME_PROPERTY, oldValue, newValue);
    return;
  }

  public Object propertyOf(String property) {

    if (LOCATION_PROPERTY.equals(property)) {
      return getLocation();
    }
    if (CONTACT_NUMBER_PROPERTY.equals(property)) {
      return getContactNumber();
    }
    if (TOTAL_AREA_PROPERTY.equals(property)) {
      return getTotalArea();
    }
    if (WAREHOUSE_PROPERTY.equals(property)) {
      return getWarehouse();
    }
    if (LATITUDE_PROPERTY.equals(property)) {
      return getLatitude();
    }
    if (LONGITUDE_PROPERTY.equals(property)) {
      return getLongitude();
    }
    if (LAST_UPDATE_TIME_PROPERTY.equals(property)) {
      return getLastUpdateTime();
    }
    if (GOODS_SHELF_LIST.equals(property)) {
      List<BaseEntity> list =
          getGoodsShelfList().stream().map(item -> item).collect(Collectors.toList());
      return list;
    }

    // other property not include here
    return super.propertyOf(property);
  }

  public void setId(String id) {
    String oldId = this.id;
    String newId = trimString(id);
    this.id = newId;
  }

  public String id() {
    doLoad();
    return getId();
  }

  public String getId() {
    return this.id;
  }

  public SupplierSpace updateId(String id) {
    String oldId = this.id;
    String newId = trimString(id);
    if (!shouldReplaceBy(newId, oldId)) {
      return this;
    }
    this.id = newId;
    if (cn.hutool.core.util.ObjectUtil.equals(newId, oldId)) {
      return this;
    }
    addPropertyChange(ID_PROPERTY, oldId, newId);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public SupplierSpace orderById(boolean asc) {
    doAddOrderBy(ID_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createIdCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(ID_PROPERTY, operator, parameters);
  }

  public SupplierSpace ignoreIdCriteria() {
    super.ignoreSearchProperty(ID_PROPERTY);
    return this;
  }

  public SupplierSpace addIdCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createIdCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeId(String id) {
    if (id != null) {
      updateId(id);
    }
  }

  public void setLocation(String location) {
    String oldLocation = this.location;
    String newLocation = trimString(location);
    this.location = newLocation;
  }

  public String location() {
    doLoad();
    return getLocation();
  }

  public String getLocation() {
    return this.location;
  }

  public SupplierSpace updateLocation(String location) {
    String oldLocation = this.location;
    String newLocation = trimString(location);
    if (!shouldReplaceBy(newLocation, oldLocation)) {
      return this;
    }
    this.location = newLocation;
    if (cn.hutool.core.util.ObjectUtil.equals(newLocation, oldLocation)) {
      return this;
    }
    addPropertyChange(LOCATION_PROPERTY, oldLocation, newLocation);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public SupplierSpace orderByLocation(boolean asc) {
    doAddOrderBy(LOCATION_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createLocationCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(LOCATION_PROPERTY, operator, parameters);
  }

  public SupplierSpace ignoreLocationCriteria() {
    super.ignoreSearchProperty(LOCATION_PROPERTY);
    return this;
  }

  public SupplierSpace addLocationCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createLocationCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeLocation(String location) {
    if (location != null) {
      updateLocation(location);
    }
  }

  public void setContactNumber(String contactNumber) {
    String oldContactNumber = this.contactNumber;
    String newContactNumber = trimString(contactNumber);
    this.contactNumber = newContactNumber;
  }

  public String contactNumber() {
    doLoad();
    return getContactNumber();
  }

  public String getContactNumber() {
    return this.contactNumber;
  }

  public SupplierSpace updateContactNumber(String contactNumber) {
    String oldContactNumber = this.contactNumber;
    String newContactNumber = trimString(contactNumber);
    if (!shouldReplaceBy(newContactNumber, oldContactNumber)) {
      return this;
    }
    this.contactNumber = newContactNumber;
    if (cn.hutool.core.util.ObjectUtil.equals(newContactNumber, oldContactNumber)) {
      return this;
    }
    addPropertyChange(CONTACT_NUMBER_PROPERTY, oldContactNumber, newContactNumber);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public SupplierSpace orderByContactNumber(boolean asc) {
    doAddOrderBy(CONTACT_NUMBER_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createContactNumberCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(CONTACT_NUMBER_PROPERTY, operator, parameters);
  }

  public SupplierSpace ignoreContactNumberCriteria() {
    super.ignoreSearchProperty(CONTACT_NUMBER_PROPERTY);
    return this;
  }

  public SupplierSpace addContactNumberCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createContactNumberCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeContactNumber(String contactNumber) {
    if (contactNumber != null) {
      updateContactNumber(contactNumber);
    }
  }

  public void setTotalArea(String totalArea) {
    String oldTotalArea = this.totalArea;
    String newTotalArea = trimString(totalArea);
    this.totalArea = newTotalArea;
  }

  public String totalArea() {
    doLoad();
    return getTotalArea();
  }

  public String getTotalArea() {
    return this.totalArea;
  }

  public SupplierSpace updateTotalArea(String totalArea) {
    String oldTotalArea = this.totalArea;
    String newTotalArea = trimString(totalArea);
    if (!shouldReplaceBy(newTotalArea, oldTotalArea)) {
      return this;
    }
    this.totalArea = newTotalArea;
    if (cn.hutool.core.util.ObjectUtil.equals(newTotalArea, oldTotalArea)) {
      return this;
    }
    addPropertyChange(TOTAL_AREA_PROPERTY, oldTotalArea, newTotalArea);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public SupplierSpace orderByTotalArea(boolean asc) {
    doAddOrderBy(TOTAL_AREA_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createTotalAreaCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(TOTAL_AREA_PROPERTY, operator, parameters);
  }

  public SupplierSpace ignoreTotalAreaCriteria() {
    super.ignoreSearchProperty(TOTAL_AREA_PROPERTY);
    return this;
  }

  public SupplierSpace addTotalAreaCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createTotalAreaCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeTotalArea(String totalArea) {
    if (totalArea != null) {
      updateTotalArea(totalArea);
    }
  }

  public void setWarehouse(Warehouse warehouse) {
    Warehouse oldWarehouse = this.warehouse;
    Warehouse newWarehouse = warehouse;
    this.warehouse = newWarehouse;
  }

  public Warehouse warehouse() {
    doLoad();
    return getWarehouse();
  }

  public Warehouse getWarehouse() {
    return this.warehouse;
  }

  public SupplierSpace updateWarehouse(Warehouse warehouse) {
    Warehouse oldWarehouse = this.warehouse;
    Warehouse newWarehouse = warehouse;
    if (!shouldReplaceBy(newWarehouse, oldWarehouse)) {
      return this;
    }
    this.warehouse = newWarehouse;
    if (cn.hutool.core.util.ObjectUtil.equals(newWarehouse, oldWarehouse)) {
      return this;
    }
    addPropertyChange(WAREHOUSE_PROPERTY, oldWarehouse, newWarehouse);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public SupplierSpace orderByWarehouse(boolean asc) {
    doAddOrderBy(WAREHOUSE_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createWarehouseCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(WAREHOUSE_PROPERTY, operator, parameters);
  }

  public SupplierSpace ignoreWarehouseCriteria() {
    super.ignoreSearchProperty(WAREHOUSE_PROPERTY);
    return this;
  }

  public SupplierSpace addWarehouseCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createWarehouseCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeWarehouse(Warehouse warehouse) {
    if (warehouse != null) {
      updateWarehouse(warehouse);
    }
  }

  public SupplierSpace updateWarehouseByReferenceId(String warehouseId) {
    updateWarehouse(Warehouse.refById(warehouseId));
    return this;
  }

  public void clearWarehouse() {
    setWarehouse(null);
    this.changed = true;
    setChecked(false);
  }

  public void setLatitude(BigDecimal latitude) {
    BigDecimal oldLatitude = this.latitude;
    BigDecimal newLatitude = latitude;
    this.latitude = newLatitude;
  }

  public BigDecimal latitude() {
    doLoad();
    return getLatitude();
  }

  public BigDecimal getLatitude() {
    return this.latitude;
  }

  public SupplierSpace updateLatitude(BigDecimal latitude) {
    BigDecimal oldLatitude = this.latitude;
    BigDecimal newLatitude = latitude;
    if (!shouldReplaceBy(newLatitude, oldLatitude)) {
      return this;
    }
    this.latitude = newLatitude;
    if (cn.hutool.core.util.ObjectUtil.equals(newLatitude, oldLatitude)) {
      return this;
    }
    addPropertyChange(LATITUDE_PROPERTY, oldLatitude, newLatitude);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public SupplierSpace orderByLatitude(boolean asc) {
    doAddOrderBy(LATITUDE_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createLatitudeCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(LATITUDE_PROPERTY, operator, parameters);
  }

  public SupplierSpace ignoreLatitudeCriteria() {
    super.ignoreSearchProperty(LATITUDE_PROPERTY);
    return this;
  }

  public SupplierSpace addLatitudeCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createLatitudeCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeLatitude(BigDecimal latitude) {
    updateLatitude(latitude);
  }

  public void setLongitude(BigDecimal longitude) {
    BigDecimal oldLongitude = this.longitude;
    BigDecimal newLongitude = longitude;
    this.longitude = newLongitude;
  }

  public BigDecimal longitude() {
    doLoad();
    return getLongitude();
  }

  public BigDecimal getLongitude() {
    return this.longitude;
  }

  public SupplierSpace updateLongitude(BigDecimal longitude) {
    BigDecimal oldLongitude = this.longitude;
    BigDecimal newLongitude = longitude;
    if (!shouldReplaceBy(newLongitude, oldLongitude)) {
      return this;
    }
    this.longitude = newLongitude;
    if (cn.hutool.core.util.ObjectUtil.equals(newLongitude, oldLongitude)) {
      return this;
    }
    addPropertyChange(LONGITUDE_PROPERTY, oldLongitude, newLongitude);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public SupplierSpace orderByLongitude(boolean asc) {
    doAddOrderBy(LONGITUDE_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createLongitudeCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(LONGITUDE_PROPERTY, operator, parameters);
  }

  public SupplierSpace ignoreLongitudeCriteria() {
    super.ignoreSearchProperty(LONGITUDE_PROPERTY);
    return this;
  }

  public SupplierSpace addLongitudeCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createLongitudeCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeLongitude(BigDecimal longitude) {
    updateLongitude(longitude);
  }

  public void setLastUpdateTime(DateTime lastUpdateTime) {
    DateTime oldLastUpdateTime = this.lastUpdateTime;
    DateTime newLastUpdateTime = lastUpdateTime;
    this.lastUpdateTime = newLastUpdateTime;
  }

  public DateTime lastUpdateTime() {
    doLoad();
    return getLastUpdateTime();
  }

  public DateTime getLastUpdateTime() {
    return this.lastUpdateTime;
  }

  public SupplierSpace updateLastUpdateTime(DateTime lastUpdateTime) {
    DateTime oldLastUpdateTime = this.lastUpdateTime;
    DateTime newLastUpdateTime = lastUpdateTime;
    if (!shouldReplaceBy(newLastUpdateTime, oldLastUpdateTime)) {
      return this;
    }
    this.lastUpdateTime = newLastUpdateTime;
    if (cn.hutool.core.util.ObjectUtil.equals(newLastUpdateTime, oldLastUpdateTime)) {
      return this;
    }
    addPropertyChange(LAST_UPDATE_TIME_PROPERTY, oldLastUpdateTime, newLastUpdateTime);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public SupplierSpace orderByLastUpdateTime(boolean asc) {
    doAddOrderBy(LAST_UPDATE_TIME_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createLastUpdateTimeCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(LAST_UPDATE_TIME_PROPERTY, operator, parameters);
  }

  public SupplierSpace ignoreLastUpdateTimeCriteria() {
    super.ignoreSearchProperty(LAST_UPDATE_TIME_PROPERTY);
    return this;
  }

  public SupplierSpace addLastUpdateTimeCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createLastUpdateTimeCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeLastUpdateTime(DateTime lastUpdateTime) {
    updateLastUpdateTime(lastUpdateTime);
  }

  public void setVersion(int version) {
    int oldVersion = this.version;
    int newVersion = version;
    this.version = newVersion;
  }

  public int version() {
    doLoad();
    return getVersion();
  }

  public int getVersion() {
    return this.version;
  }

  public SupplierSpace updateVersion(int version) {
    int oldVersion = this.version;
    int newVersion = version;
    if (!shouldReplaceBy(newVersion, oldVersion)) {
      return this;
    }
    this.version = newVersion;
    if (cn.hutool.core.util.ObjectUtil.equals(newVersion, oldVersion)) {
      return this;
    }
    addPropertyChange(VERSION_PROPERTY, oldVersion, newVersion);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public SupplierSpace orderByVersion(boolean asc) {
    doAddOrderBy(VERSION_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createVersionCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(VERSION_PROPERTY, operator, parameters);
  }

  public SupplierSpace ignoreVersionCriteria() {
    super.ignoreSearchProperty(VERSION_PROPERTY);
    return this;
  }

  public SupplierSpace addVersionCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createVersionCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeVersion(int version) {
    if (version >= 0) {
      updateVersion(version);
    }
  }

  public SmartList<GoodsShelf> getGoodsShelfList() {
    if (this.mGoodsShelfList == null) {
      this.mGoodsShelfList = new SmartList<GoodsShelf>();
      this.mGoodsShelfList.setListInternalName(GOODS_SHELF_LIST);
      // 有名字，便于做权限控制
    }

    return this.mGoodsShelfList;
  }

  public SmartList<GoodsShelf> goodsShelfList() {

    doLoadChild(GOODS_SHELF_LIST);

    return getGoodsShelfList();
  }

  public void setGoodsShelfList(SmartList<GoodsShelf> goodsShelfList) {
    for (GoodsShelf goodsShelf : goodsShelfList) {
      goodsShelf.setSupplierSpace(this);
    }

    this.mGoodsShelfList = goodsShelfList;
    this.mGoodsShelfList.setListInternalName(GOODS_SHELF_LIST);
  }

  public SupplierSpace addGoodsShelf(GoodsShelf goodsShelf) {
    goodsShelf.updateSupplierSpace(this);
    getGoodsShelfList().add(goodsShelf);
    return this;
  }

  public SupplierSpace addGoodsShelfList(SmartList<GoodsShelf> goodsShelfList) {
    for (GoodsShelf goodsShelf : goodsShelfList) {
      goodsShelf.updateSupplierSpace(this);
    }

    Map<String, GoodsShelf> mapById = goodsShelfList.mapWithId();
    getGoodsShelfList().removeIf(item -> mapById.get(item.getId()) != null);
    getGoodsShelfList().addAll(goodsShelfList);
    return this;
  }

  public void mergeGoodsShelfList(SmartList<GoodsShelf> goodsShelfList) {
    if (goodsShelfList == null) {
      return;
    }
    if (goodsShelfList.isEmpty()) {
      return;
    }
    addGoodsShelfList(goodsShelfList);
  }

  public GoodsShelf removeGoodsShelf(GoodsShelf goodsShelfIndex) {

    int index = getGoodsShelfList().indexOf(goodsShelfIndex);
    if (index < 0) {
      String message =
          "GoodsShelf("
              + goodsShelfIndex.getId()
              + ") with version='"
              + goodsShelfIndex.getVersion()
              + "' NOT found!";
      throw new IllegalStateException(message);
    }
    GoodsShelf goodsShelf = getGoodsShelfList().get(index);
    // goodsShelf.clearSupplierSpace(); //disconnect with SupplierSpace
    goodsShelf.clearFromAll(); // disconnect with SupplierSpace

    boolean result = getGoodsShelfList().planToRemove(goodsShelf);
    if (!result) {
      String message =
          "GoodsShelf("
              + goodsShelfIndex.getId()
              + ") with version='"
              + goodsShelfIndex.getVersion()
              + "' NOT found!";
      throw new IllegalStateException(message);
    }
    return goodsShelf;
  }
  // 断舍离
  public void breakWithGoodsShelf(GoodsShelf goodsShelf) {

    if (goodsShelf == null) {
      return;
    }
    goodsShelf.setSupplierSpace(null);
    // getGoodsShelfList().remove();

  }

  public boolean hasGoodsShelf(GoodsShelf goodsShelf) {

    return getGoodsShelfList().contains(goodsShelf);
  }

  public void copyGoodsShelfFrom(GoodsShelf goodsShelf) {

    GoodsShelf goodsShelfInList = findTheGoodsShelf(goodsShelf);
    GoodsShelf newGoodsShelf = new GoodsShelf();
    goodsShelfInList.copyTo(newGoodsShelf);
    newGoodsShelf.setVersion(0); // will trigger copy
    getGoodsShelfList().add(newGoodsShelf);
    addItemToFlexiableObject(COPIED_CHILD, newGoodsShelf);
  }

  public GoodsShelf findTheGoodsShelf(GoodsShelf goodsShelf) {

    int index = getGoodsShelfList().indexOf(goodsShelf);
    // The input parameter must have the same id and version number.
    if (index < 0) {
      String message =
          "GoodsShelf("
              + goodsShelf.getId()
              + ") with version='"
              + goodsShelf.getVersion()
              + "' NOT found!";
      throw new IllegalStateException(message);
    }

    return getGoodsShelfList().get(index);
    // Performance issue when using LinkedList, but it is almost an ArrayList for sure!
  }

  public void cleanUpGoodsShelfList() {
    getGoodsShelfList().clear();
  }

  public void collectReferences(
      BaseEntity owner, List<BaseEntity> entityList, String internalType) {

    addToEntityList(this, entityList, getWarehouse(), internalType);
  }

  public List<BaseEntity> collectReferencesFromLists(String internalType) {

    List<BaseEntity> entityList = new ArrayList<BaseEntity>();
    collectFromList(this, entityList, getGoodsShelfList(), internalType);

    return entityList;
  }

  public List<SmartList<?>> getAllRelatedLists() {
    List<SmartList<?>> listOfList = new ArrayList<SmartList<?>>();

    listOfList.add(getGoodsShelfList());

    return listOfList;
  }

  public List<KeyValuePair> keyValuePairOf() {
    List<KeyValuePair> result = super.keyValuePairOf();

    appendKeyValuePair(result, ID_PROPERTY, getId());
    appendKeyValuePair(result, LOCATION_PROPERTY, getLocation());
    appendKeyValuePair(result, CONTACT_NUMBER_PROPERTY, getContactNumber());
    appendKeyValuePair(result, TOTAL_AREA_PROPERTY, getTotalArea());
    appendKeyValuePair(result, WAREHOUSE_PROPERTY, getWarehouse());
    appendKeyValuePair(result, LATITUDE_PROPERTY, getLatitude());
    appendKeyValuePair(result, LONGITUDE_PROPERTY, getLongitude());
    appendKeyValuePair(result, LAST_UPDATE_TIME_PROPERTY, getLastUpdateTime());
    appendKeyValuePair(result, VERSION_PROPERTY, getVersion());
    appendKeyValuePair(result, GOODS_SHELF_LIST, getGoodsShelfList());
    if (!getGoodsShelfList().isEmpty()) {
      appendKeyValuePair(result, "goodsShelfCount", getGoodsShelfList().getTotalCount());
      appendKeyValuePair(
          result, "goodsShelfCurrentPageNumber", getGoodsShelfList().getCurrentPageNumber());
    }

    if (this.valueByKey("valuesOfGroupBy") != null) {
      appendKeyValuePair(result, "valuesOfGroupBy", this.valueByKey("valuesOfGroupBy"));
    }
    return result;
  }

  public BaseEntity copyTo(BaseEntity baseDest) {

    super.copyTo(baseDest);
    if (baseDest instanceof SupplierSpace) {

      SupplierSpace dest = (SupplierSpace) baseDest;

      dest.setId(getId());
      dest.setLocation(getLocation());
      dest.setContactNumber(getContactNumber());
      dest.setTotalArea(getTotalArea());
      dest.setWarehouse(getWarehouse());
      dest.setLatitude(getLatitude());
      dest.setLongitude(getLongitude());
      dest.setLastUpdateTime(getLastUpdateTime());
      dest.setVersion(getVersion());
      dest.setGoodsShelfList(getGoodsShelfList());
    }

    return baseDest;
  }

  public BaseEntity mergeDataFrom(BaseEntity sourceEntity) {

    if (sourceEntity instanceof SupplierSpace) {

      SupplierSpace source = (SupplierSpace) sourceEntity;

      mergeId(source.getId());
      mergeLocation(source.getLocation());
      mergeContactNumber(source.getContactNumber());
      mergeTotalArea(source.getTotalArea());
      mergeWarehouse(source.getWarehouse());
      mergeLatitude(source.getLatitude());
      mergeLongitude(source.getLongitude());
      mergeLastUpdateTime(source.getLastUpdateTime());
      mergeVersion(source.getVersion());
      mergeGoodsShelfList(source.getGoodsShelfList());
    }

    return this;
  }

  public BaseEntity mergePrimitiveDataFrom(BaseEntity sourceEntity) {

    // super.mergePrimitiveDataFrom(sourceEntity);
    if (sourceEntity instanceof SupplierSpace) {

      SupplierSpace source = (SupplierSpace) sourceEntity;

      mergeId(source.getId());
      mergeLocation(source.getLocation());
      mergeContactNumber(source.getContactNumber());
      mergeTotalArea(source.getTotalArea());
      mergeLatitude(source.getLatitude());
      mergeLongitude(source.getLongitude());
      mergeLastUpdateTime(source.getLastUpdateTime());
      mergeVersion(source.getVersion());
    }
    return this;
  }

  public Object[] toFlatArray() {
    return new Object[] {
      getId(),
      getLocation(),
      getContactNumber(),
      getTotalArea(),
      getWarehouse(),
      getLatitude(),
      getLongitude(),
      getLastUpdateTime(),
      getVersion()
    };
  }

  public boolean checkIfEligibleForDelete(Object ctx) {
    String id = getId();
    if (cn.hutool.core.util.ObjectUtil.isEmpty(id)) {
      throw new ErrorMessageException("缺少参数id");
    }
    SupplierSpace checkSupplierSpace =
        Q.supplierSpaceWithIdField()
            .filterById(id)
            .selectGoodsShelfList(Q.goodsShelfWithIdField().limit(0, 1))
            .execute(ctx);

    return checkSupplierSpace != null
        && !checkSupplierSpace.getAllRelatedLists().stream()
            .flatMap(subList -> subList.stream())
            .findFirst()
            .isPresent();
  }

  public SupplierSpace save(com.doublechaintech.retailscm.RetailscmUserContext ctx) {
    try {
      com.doublechaintech.retailscm.RetailscmBaseUtils.saveGraph(ctx, this);
    } catch (Exception pE) {
      cn.hutool.core.exceptions.ExceptionUtil.wrapAndThrow(pE);
    }
    return this;
  }

  public String toString() {
    StringBuilder stringBuilder = new StringBuilder(128);

    stringBuilder.append("SupplierSpace{");
    stringBuilder.append("\tid='" + getId() + "';");
    stringBuilder.append("\tlocation='" + getLocation() + "';");
    stringBuilder.append("\tcontactNumber='" + getContactNumber() + "';");
    stringBuilder.append("\ttotalArea='" + getTotalArea() + "';");
    if (getWarehouse() != null) {
      stringBuilder.append("\twarehouse='Warehouse(" + getWarehouse().getId() + ")';");
    }
    stringBuilder.append("\tlatitude='" + getLatitude() + "';");
    stringBuilder.append("\tlongitude='" + getLongitude() + "';");
    stringBuilder.append("\tlastUpdateTime='" + getLastUpdateTime() + "';");
    stringBuilder.append("\tversion='" + getVersion() + "';");
    stringBuilder.append("}");

    return stringBuilder.toString();
  }

  // provide number calculation function

}
