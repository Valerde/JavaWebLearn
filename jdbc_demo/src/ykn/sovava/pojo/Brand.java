package ykn.sovava.pojo;

/**
 * Description: 品牌
 * 推荐在实体类中使用包装类型
 *
 * @author: ykn
 * @date: 2022年07月05日 18:02
 **/
public class Brand {

    // 	id 主键
    private int id;
    // 	品牌名称
    private String brandName;
    // 	企业名称
    private String companyName;
    // 	排序字段
    private int ordered;
    private String description;
    // 	状态:0:禁用 1:启用
    private Integer status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public int getOrdered() {
        return ordered;
    }

    public void setOrdered(int ordered) {
        this.ordered = ordered;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Brand{" +
                "id=" + id +
                ", brandName='" + brandName + '\'' +
                ", companyName='" + companyName + '\'' +
                ", ordered=" + ordered +
                ", description='" + description + '\'' +
                ", status=" + status +
                '}';
    }
}
