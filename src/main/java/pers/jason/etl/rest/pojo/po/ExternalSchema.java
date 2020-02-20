package pers.jason.etl.rest.pojo.po;

import com.google.common.collect.Sets;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pers.jason.etl.rest.pojo.MetadataType;

import java.util.Set;

/**
 * @author Jason
 * @date 2020/2/17 23:17
 * @description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExternalSchema extends Schema {

  private Long platformId;

  private String initCommands;

  private String cName;

  private Set<ExternalTable> tableSet = Sets.newHashSet();

  @Override
  public <T extends Metadata> Set<T> getChild() {
    return (Set<T>) tableSet;
  }

  @Override
  public MetadataType returnMetadataType() {
    return MetadataType.SCHEMA;
  }

  @Override
  public void setParentId(Long id) {
    this.setPlatformId(id);
  }
}
