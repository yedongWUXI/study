package mytool;

/**
 * @Description: java类作用描述
 * @Author: yedong
 * @Date: 2019/7/29 14:52
 * @Modified by:
 */

public class ExcelToSql {
    static String fileName = "C:\\Users\\yedong\\Desktop\\excelToSql\\test.xlsx";

    static String sql = "";

    static String comment = "";

    static String pk = "";

    public static void main(String[] args) {
        ExcelUtils excelUtils = new ExcelUtils(fileName, "Sheet6");
        String tableName = excelUtils.getCellforString(0, 0);
        String tableNameCn = excelUtils.getCellforString(0, 1);
        String pkName = excelUtils.getCellforString(2, 0);
        sql = "create table " + tableName + "(";
        comment = "comment on TABLE " + tableName + " is '" + tableNameCn + "';";
        for (int i = 2; i < excelUtils.getRowsNum(); i++) {
            comment = comment + "\n" + "comment on column " + tableName + "." + excelUtils.getCellforString(i, 0) + " is '" + excelUtils.getCellforString(i, 3) + "';";
            if ("是".equals(excelUtils.getCellforString(i, 5))) {
                sql = sql + excelUtils.getCellforString(i, 0) + " " + excelUtils.getCellforString(i, 1) + " not NULL" + ", ";
            } else
                sql = sql + excelUtils.getCellforString(i, 0) + " " + excelUtils.getCellforString(i, 1) + ", ";
        }

        pk = "alter table " + tableName + " add constraint " + "PK_" + tableName + " primary key (" + pkName + ");";

        System.out.println(sql.substring(0, sql.lastIndexOf(",")) + ");");
        System.out.println(comment);
        System.out.println(pk);
    }
}
