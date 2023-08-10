public class getData {
    private String filePath="C:\\JAVA\\the_Demon_of_Rhythm\\dict_concised_2014_20230628.xlsx";
    public Workbook getWorkbook() throws IOException {
        Workbook workbook = null;
        if (filePath.endsWith(".xls")) {
            workbook = new HSSFWorkbook(new FileInputStream(filePath));
        } else if (filePath.endsWith(".xlsx")) {
            workbook = new XSSFWorkbook(new FileInputStream(filePath));
        }
        return workbook;
    }
}