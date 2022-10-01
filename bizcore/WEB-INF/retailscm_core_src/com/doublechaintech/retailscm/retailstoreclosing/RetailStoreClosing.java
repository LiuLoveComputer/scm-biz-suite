package com.doublechaintech.retailscm.retailstoreclosing;

import java.util.*;
import java.util.stream.Collectors;
import java.math.BigDecimal;
import com.terapico.caf.*;
import com.doublechaintech.retailscm.search.*;
import com.doublechaintech.retailscm.*;
import com.doublechaintech.retailscm.utils.*;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.terapico.caf.baseelement.MemberMetaInfo;
import com.doublechaintech.retailscm.retailstore.RetailStore;

@JsonSerialize(using = RetailStoreClosingSerializer.class)
public class RetailStoreClosing extends BaseEntity implements java.io.Serializable {

  public void transferAllRelationshipsTo(RetailStoreClosing target) {
    if (target == null) {
      return;
    }
    target.addRetailStoreList(this.getRetailStoreList());
  }

  public static final String ID_PROPERTY = "id";
  public static final String COMMENT_PROPERTY = "comment";
  public static final String VERSION_PROPERTY = "version";

  public static final String RETAIL_STORE_LIST = "retailStoreList";

  public static final String INTERNAL_TYPE = "RetailStoreClosing";

  public String getInternalType() {
    return INTERNAL_TYPE;
  }

  protected static List<MemberMetaInfo> memberMetaInfoList = new ArrayList<>();

  static {
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(ID_PROPERTY, "id", "ID").withType("id", String.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(COMMENT_PROPERTY, "comment", "评论")
            .withType("string", String.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(VERSION_PROPERTY, "version", "版本").withType("version", "int"));

    memberMetaInfoList.add(
        MemberMetaInfo.referBy(RETAIL_STORE_LIST, "closing", "零售门店列表")
            .withType("retail_store", RetailStore.class));
  }

  public List<MemberMetaInfo> getMemberMetaInfoList() {
    return memberMetaInfoList;
  }

  public String[] getPropertyNames() {
    return new String[] {ID_PROPERTY, COMMENT_PROPERTY, VERSION_PROPERTY};
  }

  public Map<String, String> getReferProperties() {
    Map<String, String> refers = new HashMap<>();

    refers.put(RETAIL_STORE_LIST, "closing");

    return refers;
  }

  public Map<String, Class> getReferTypes() {
    Map<String, Class> refers = new HashMap<>();

    refers.put(RETAIL_STORE_LIST, RetailStore.class);

    return refers;
  }

  public Map<String, Class<? extends BaseEntity>> getParentProperties() {
    Map<String, Class<? extends BaseEntity>> parents = new HashMap<>();

    return parents;
  }
  /*
  public RetailStoreClosing want(Class<? extends BaseEntity>... classes) {
      doWant(classes);
      return this;
    }

  public RetailStoreClosing wants(Class<? extends BaseEntity>... classes) {
    doWants(classes);
    return this;
  }*/

  public String getDisplayName() {

    String displayName = getComment();
    if (displayName != null) {
      return displayName;
    }

    return super.getDisplayName();
  }

  private static final long serialVersionUID = 1L;

  protected String id;
  protected String comment;
  protected int version;

  protected SmartList<RetailStore> mRetailStoreList;

  public RetailStoreClosing() {
    // lazy load for all the properties
  }

  public static RetailStoreClosing withId(String id) {
    RetailStoreClosing retailStoreClosing = new RetailStoreClosing();
    retailStoreClosing.setId(id);
    retailStoreClosing.setVersion(Integer.MAX_VALUE);
    retailStoreClosing.setChecked(true);
    return retailStoreClosing;
  }

  public static RetailStoreClosing refById(String id) {
    return withId(id);
  }

  public RetailStoreClosing limit(int count) {
    doAddLimit(0, count);
    return this;
  }

  public RetailStoreClosing limit(int start, int count) {
    doAddLimit(start, count);
    return this;
  }

  public static RetailStoreClosing searchExample() {
    RetailStoreClosing retailStoreClosing = new RetailStoreClosing();
    retailStoreClosing.setVersion(UNSET_INT);

    return retailStoreClosing;
  }

  // disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
  /*
  public 	void clearFromAll(){

  	this.changed = true;
  	setChecked(false);
  }  */

  // Support for changing the property

  public void changeProperty(String property, String newValueExpr) {

    if (COMMENT_PROPERTY.equals(property)) {
      changeCommentProperty(newValueExpr);
    }
  }

  protected void changeCommentProperty(String newValueExpr) {

    String oldValue = getComment();
    String newValue = parseString(newValueExpr);
    if (equalsString(oldValue, newValue)) {
      return; // they can be both null, or exact the same object, this is much faster than equals
              // function
    }
    // they are surely different each other
    updateComment(newValue);
    this.onChangeProperty(COMMENT_PROPERTY, oldValue, newValue);
    return;
  }

  public Object propertyOf(String property) {

    if (COMMENT_PROPERTY.equals(property)) {
      return getComment();
    }
    if (RETAIL_STORE_LIST.equals(property)) {
      List<BaseEntity> list =
          getRetailStoreList().stream().map(item -> item).collect(Collectors.toList());
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

  public RetailStoreClosing updateId(String id) {
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

  public RetailStoreClosing orderById(boolean asc) {
    doAddOrderBy(ID_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createIdCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(ID_PROPERTY, operator, parameters);
  }

  public RetailStoreClosing ignoreIdCriteria() {
    super.ignoreSearchProperty(ID_PROPERTY);
    return this;
  }

  public RetailStoreClosing addIdCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createIdCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeId(String id) {
    if (id != null) {
      updateId(id);
    }
  }

  public void setComment(String comment) {
    String oldComment = this.comment;
    String newComment = trimString(comment);
    this.comment = newComment;
  }

  public String comment() {
    doLoad();
    return getComment();
  }

  public String getComment() {
    return this.comment;
  }

  public RetailStoreClosing updateComment(String comment) {
    String oldComment = this.comment;
    String newComment = trimString(comment);
    if (!shouldReplaceBy(newComment, oldComment)) {
      return this;
    }
    this.comment = newComment;
    if (cn.hutool.core.util.ObjectUtil.equals(newComment, oldComment)) {
      return this;
    }
    addPropertyChange(COMMENT_PROPERTY, oldComment, newComment);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public RetailStoreClosing orderByComment(boolean asc) {
    doAddOrderBy(COMMENT_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createCommentCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(COMMENT_PROPERTY, operator, parameters);
  }

  public RetailStoreClosing ignoreCommentCriteria() {
    super.ignoreSearchProperty(COMMENT_PROPERTY);
    return this;
  }

  public RetailStoreClosing addCommentCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createCommentCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeComment(String comment) {
    if (comment != null) {
      updateComment(comment);
    }
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

  public RetailStoreClosing updateVersion(int version) {
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

  public RetailStoreClosing orderByVersion(boolean asc) {
    doAddOrderBy(VERSION_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createVersionCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(VERSION_PROPERTY, operator, parameters);
  }

  public RetailStoreClosing ignoreVersionCriteria() {
    super.ignoreSearchProperty(VERSION_PROPERTY);
    return this;
  }

  public RetailStoreClosing addVersionCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createVersionCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeVersion(int version) {
    if (version >= 0) {
      updateVersion(version);
    }
  }

  public SmartList<RetailStore> getRetailStoreList() {
    if (this.mRetailStoreList == null) {
      this.mRetailStoreList = new SmartList<RetailStore>();
      this.mRetailStoreList.setListInternalName(RETAIL_STORE_LIST);
      // 有名字，便于做权限控制
    }

    return this.mRetailStoreList;
  }

  public SmartList<RetailStore> retailStoreList() {

    doLoadChild(RETAIL_STORE_LIST);

    return getRetailStoreList();
  }

  public void setRetailStoreList(SmartList<RetailStore> retailStoreList) {
    for (RetailStore retailStore : retailStoreList) {
      retailStore.setClosing(this);
    }

    this.mRetailStoreList = retailStoreList;
    this.mRetailStoreList.setListInternalName(RETAIL_STORE_LIST);
  }

  public RetailStoreClosing addRetailStore(RetailStore retailStore) {
    retailStore.updateClosing(this);
    getRetailStoreList().add(retailStore);
    return this;
  }

  public RetailStoreClosing addRetailStoreList(SmartList<RetailStore> retailStoreList) {
    for (RetailStore retailStore : retailStoreList) {
      retailStore.updateClosing(this);
    }

    Map<String, RetailStore> mapById = retailStoreList.mapWithId();
    getRetailStoreList().removeIf(item -> mapById.get(item.getId()) != null);
    getRetailStoreList().addAll(retailStoreList);
    return this;
  }

  public void mergeRetailStoreList(SmartList<RetailStore> retailStoreList) {
    if (retailStoreList == null) {
      return;
    }
    if (retailStoreList.isEmpty()) {
      return;
    }
    addRetailStoreList(retailStoreList);
  }

  public RetailStore removeRetailStore(RetailStore retailStoreIndex) {

    int index = getRetailStoreList().indexOf(retailStoreIndex);
    if (index < 0) {
      String message =
          "RetailStore("
              + retailStoreIndex.getId()
              + ") with version='"
              + retailStoreIndex.getVersion()
              + "' NOT found!";
      throw new IllegalStateException(message);
    }
    RetailStore retailStore = getRetailStoreList().get(index);
    // retailStore.clearClosing(); //disconnect with Closing
    retailStore.clearFromAll(); // disconnect with Closing

    boolean result = getRetailStoreList().planToRemove(retailStore);
    if (!result) {
      String message =
          "RetailStore("
              + retailStoreIndex.getId()
              + ") with version='"
              + retailStoreIndex.getVersion()
              + "' NOT found!";
      throw new IllegalStateException(message);
    }
    return retailStore;
  }
  // 断舍离
  public void breakWithRetailStore(RetailStore retailStore) {

    if (retailStore == null) {
      return;
    }
    retailStore.setClosing(null);
    // getRetailStoreList().remove();

  }

  public boolean hasRetailStore(RetailStore retailStore) {

    return getRetailStoreList().contains(retailStore);
  }

  public void copyRetailStoreFrom(RetailStore retailStore) {

    RetailStore retailStoreInList = findTheRetailStore(retailStore);
    RetailStore newRetailStore = new RetailStore();
    retailStoreInList.copyTo(newRetailStore);
    newRetailStore.setVersion(0); // will trigger copy
    getRetailStoreList().add(newRetailStore);
    addItemToFlexiableObject(COPIED_CHILD, newRetailStore);
  }

  public RetailStore findTheRetailStore(RetailStore retailStore) {

    int index = getRetailStoreList().indexOf(retailStore);
    // The input parameter must have the same id and version number.
    if (index < 0) {
      String message =
          "RetailStore("
              + retailStore.getId()
              + ") with version='"
              + retailStore.getVersion()
              + "' NOT found!";
      throw new IllegalStateException(message);
    }

    return getRetailStoreList().get(index);
    // Performance issue when using LinkedList, but it is almost an ArrayList for sure!
  }

  public void cleanUpRetailStoreList() {
    getRetailStoreList().clear();
  }

  public void collectReferences(
      BaseEntity owner, List<BaseEntity> entityList, String internalType) {}

  public List<BaseEntity> collectReferencesFromLists(String internalType) {

    List<BaseEntity> entityList = new ArrayList<BaseEntity>();
    collectFromList(this, entityList, getRetailStoreList(), internalType);

    return entityList;
  }

  public List<SmartList<?>> getAllRelatedLists() {
    List<SmartList<?>> listOfList = new ArrayList<SmartList<?>>();

    listOfList.add(getRetailStoreList());

    return listOfList;
  }

  public List<KeyValuePair> keyValuePairOf() {
    List<KeyValuePair> result = super.keyValuePairOf();

    appendKeyValuePair(result, ID_PROPERTY, getId());
    appendKeyValuePair(result, COMMENT_PROPERTY, getComment());
    appendKeyValuePair(result, VERSION_PROPERTY, getVersion());
    appendKeyValuePair(result, RETAIL_STORE_LIST, getRetailStoreList());
    if (!getRetailStoreList().isEmpty()) {
      appendKeyValuePair(result, "retailStoreCount", getRetailStoreList().getTotalCount());
      appendKeyValuePair(
          result, "retailStoreCurrentPageNumber", getRetailStoreList().getCurrentPageNumber());
    }

    if (this.valueByKey("valuesOfGroupBy") != null) {
      appendKeyValuePair(result, "valuesOfGroupBy", this.valueByKey("valuesOfGroupBy"));
    }
    return result;
  }

  public BaseEntity copyTo(BaseEntity baseDest) {

    super.copyTo(baseDest);
    if (baseDest instanceof RetailStoreClosing) {

      RetailStoreClosing dest = (RetailStoreClosing) baseDest;

      dest.setId(getId());
      dest.setComment(getComment());
      dest.setVersion(getVersion());
      dest.setRetailStoreList(getRetailStoreList());
    }

    return baseDest;
  }

  public BaseEntity mergeDataFrom(BaseEntity sourceEntity) {

    if (sourceEntity instanceof RetailStoreClosing) {

      RetailStoreClosing source = (RetailStoreClosing) sourceEntity;

      mergeId(source.getId());
      mergeComment(source.getComment());
      mergeVersion(source.getVersion());
      mergeRetailStoreList(source.getRetailStoreList());
    }

    return this;
  }

  public BaseEntity mergePrimitiveDataFrom(BaseEntity sourceEntity) {

    // super.mergePrimitiveDataFrom(sourceEntity);
    if (sourceEntity instanceof RetailStoreClosing) {

      RetailStoreClosing source = (RetailStoreClosing) sourceEntity;

      mergeId(source.getId());
      mergeComment(source.getComment());
      mergeVersion(source.getVersion());
    }
    return this;
  }

  public Object[] toFlatArray() {
    return new Object[] {getId(), getComment(), getVersion()};
  }

  public boolean checkIfEligibleForDelete(Object ctx) {
    String id = getId();
    if (cn.hutool.core.util.ObjectUtil.isEmpty(id)) {
      throw new ErrorMessageException("缺少参数id");
    }
    RetailStoreClosing checkRetailStoreClosing =
        Q.retailStoreClosingWithIdField()
            .filterById(id)
            .selectRetailStoreList(Q.retailStoreWithIdField().limit(0, 1))
            .execute(ctx);

    return checkRetailStoreClosing != null
        && !checkRetailStoreClosing.getAllRelatedLists().stream()
            .flatMap(subList -> subList.stream())
            .findFirst()
            .isPresent();
  }

  public RetailStoreClosing save(com.doublechaintech.retailscm.RetailscmUserContext ctx) {
    try {
      com.doublechaintech.retailscm.RetailscmBaseUtils.saveGraph(ctx, this);
    } catch (Exception pE) {
      cn.hutool.core.exceptions.ExceptionUtil.wrapAndThrow(pE);
    }
    return this;
  }

  public String toString() {
    StringBuilder stringBuilder = new StringBuilder(128);

    stringBuilder.append("RetailStoreClosing{");
    stringBuilder.append("\tid='" + getId() + "';");
    stringBuilder.append("\tcomment='" + getComment() + "';");
    stringBuilder.append("\tversion='" + getVersion() + "';");
    stringBuilder.append("}");

    return stringBuilder.toString();
  }

  // provide number calculation function

}
