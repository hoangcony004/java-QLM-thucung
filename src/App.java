import java.util.Scanner;
import static java.lang.System.out;

class App {
    public static void main(String[] args) throws Exception {
        while (true) {
            //// #region
            // out.print("\n+----------------------------------------------------------------------+");
            // out.print("\n| CHƯƠNG TRÌNH QUẢN LÝ SINH VIÊN. (c) 2022.04.22 11h54 |");
            // out.print("\n+--------------------------------MENU----------------------------------+");
            // out.print("\n| 1.Thêm | 2.Sửa | 3.Xoá | 4.Sắp Xếp | 5.Thống Kê | 6.MMA |
            //// 7.Tìm Kiếm |");
            // out.print("\n| 8.Ghi File | 9. Đọc File | 0. Thoát |");
            // out.print("\n+----------------------------------------------------------------------+");
            //// #endregion

            out.print("\n+----------------------------------------------------------------------+");
            out.print("\n|                  CHƯƠNG TRÌNH QUẢN LÝ THÚ CƯNG(PET)                  |");
            out.print("\n+--------------------------------MENU----------------------------------+");
            out.print("\n| 1.Nhập | 2.Thêm | 3.Sửa  |  4.Xóa  |                                 |");
            out.print("\n| 5.Sắp Xếp | 6.Thống Kê | 7.MMA |                                     |");
            out.print("\n| 8.Tìm Kiếm |                                                         |");
            out.print("\n| 9.Ghi File | 10. Đọc File |                                          |");
            out.print("\n| 0. Thoát  |                                                          |");
            out.print("\n+----------------------------------------------------------------------+");

            out.print("\n Chọn menu: ");
            var scan = new Scanner(System.in);
            var menu = scan.nextInt();
            // scan.close();

            switch (menu) {
                case 1:
                    // làm việc 1
                    MảngThúCưng.Nhập();
                    break;
                case 2:
                    // làm việc 2
                    MảngThúCưng.Thêm();
                    break;
                case 3:
                    // làm việc 3
                    MảngThúCưng.Sửa();
                    break;
                case 4:
                    // làm việc 4
                    MảngThúCưng.Xóa();
                    break;
                case 5:
                    // làm việc 5
                    MảngThúCưng.XếpTăngDầnTheoCânNặng();
                    break;
                case 6:
                    // làm việc 6
                    MảngThúCưng.PhânLoạiTheoGiớiTính();

                    break;
                case 7:
                    // làm việc 7
                    MảngThúCưng.MMA();

                    break;
                case 8:
                    // làm việc 8
                    MảngThúCưng.Tìm();

                    break;
                case 9:
                    // làm việc 9
                    // MảngThúCưng.GhiFileJSON();

                case 10:
                    // MảngThúCưng.ĐọcFileJSON();
                    break;
                case 0:
                    out.print("\n Đang thoát...");
                    // Thread.sleep(3000);
                    scan.close();
                    System.exit(0);
                    break;
                default:
                    out.print("\n Hãy nhập menu hợp lệ !");
                    break;
            }

        } // kết thúc vòng lặp menu
    }
}