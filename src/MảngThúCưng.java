import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import static java.lang.System.out;

import java.io.Writer;
import java.io.BufferedReader;
import java.io.BufferedWriter;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @todo Bổ sung mã Java kiểm tra lỗi,
 *       rà soát các tình huống dị thường có thể xảy ra.
 *       Ví dụ: chỉ số nằm ngoài phạm vi độ dài mảng.
 *       Mảng bị rỗng.
 */
class// lớp
MảngThúCưng {
    // Dữ liệu
    // static ThúCưng[] mảng; // null
    static ThúCưng[] mảng = new ThúCưng[0];

    static ThúCưng[] ds() {
        return mảng;
    }
    //#region
    // Hành Động, Thao Tác Dữ Liệu
    // static void Gán() {

    //     // Khởi tạo sinh viên
    //     var sv1 = new ThúCưng();
    //     sv1.HọTên = "Nobita";
    //     sv1.NămSinh = 1995;
    //     sv1.Điểm = 6.5f;
    //     sv1.NhómMáu = 'A';
    //     sv1.Giới = true;

    //     var sv2 = new ThúCưng();
    //     sv2.HọTên = "Xuka";
    //     sv2.NămSinh = 1996;
    //     sv2.Điểm = 9.5f;
    //     sv2.NhómMáu = 'B';
    //     sv2.Giới = false;

    //     var sv3 = new ThúCưng();
    //     sv3.HọTên = "Chaien";
    //     sv3.NămSinh = 1994;
    //     sv3.Điểm = 7.5f;
    //     sv3.NhómMáu = 'B';
    //     sv3.Giới = false;

    //     mảng = new ThúCưng[] {
    //             sv1, sv2, sv3
    //     };
    // }
    //#endregion

    static void Nhập() {
        var scan = new Scanner(System.in);

        // Nhập độ dài mảng
        int độ_dài;
        out.print("\n Nhập độ dài mảng: ");
        độ_dài = scan.nextInt();
        // scan.close();

        // khởi tạo
        mảng = new ThúCưng[độ_dài]; // 3 phần tử đang null

        // Nhập dữ liệu cho từng phần tử
        for (int i = 0; i < mảng.length; i++) {

            var tc = new ThúCưng();
            out.printf("\n Nhập dữ liệu cho phần tử mảng[%d]: ", i);
            // Nhập tên
            out.print("\n Nhập tên: ");
            tc.Tên = scan.next();
            // scan.close();

            // Nhập năm
            out.print("\n Nhập Tuổi của PET: ");
            tc.Tuổi = scan.nextInt();

            // Nhập điểm
            out.print("\n Nhập Cân Nặng: ");
            tc.CânNặng = scan.nextFloat();

            // Nhập nhóm
            out.print("\n Nhập nhóm máu(A, B, O): ");
            tc.NhómMáu = scan.next().charAt(0);

            // Nhập giới
            out.print("\n Giới tính (true=Đực/false=Cái): ");
            tc.GiớiTính = scan.nextBoolean();// Java không cho chuyển đổi qua lại giữa bool và
                                                          // int

            // Đẩy sinh viên vào mảng/danh sách sau khi khởi tạo
            mảng[i] = tc; // Biến phái sinh
            // String GiớiTính_Text = GiớiTính ? "Đực" : "Cái";
            // scan.close();

        }

        // Thông báo đã nhập
        out.println("\n Đã hoàn tất việc nhập mảng !");
    }

    static void Xuất() {

        // in cột
        Cột();

        // in các dòng
        for (int i = 0; i < mảng.length; i++) {
            int stt = i + 1;
            ThúCưng dữ_liệu = mảng[i];

            Dòng(dữ_liệu, stt);
        }

    }

    static void Bảng() {
        out.print("\n Bảng Dữ Liệu Thú Cưng:");

        // in cột
        Cột();

        // in các dòng
        // @todo Nếu dữ liệu dòng NULL thì sao ?
        for (int i = 0; i < mảng.length; i++) {
            int stt = i + 1;
            ThúCưng dữ_liệu = mảng[i];
            Dòng(dữ_liệu, stt);
        }

    }

    static// Hàm hiện
    void Cột() {
        out.print("\n+-------------------------------------------------------------+");
        out.print("\n| STT | TÊN THÚ CƯNG | TUỔI | CÂN NẶNG | NHÓM MÁU | GIỚI TÍNH |");
        out.print("\n+-------------------------------------------------------------+");
    }

    static// Hàm hiện
    void Dòng(ThúCưng đt, int stt) {
        // String GiớiTính_Text = (đt.GiớiTính==true) ? "Nam" : "Nữ";
        String GiớiTính = đt.GiớiTính ? "Nam" : "Nữ";

        out.printf("\n| %3d | %12s | %4d | %8.2f | %8s | %9s |",
                stt, đt.Tên, đt.Tuổi, đt.CânNặng, đt.NhómMáu, đt.GiớiTính);
        out.print("\n+--------------------------------------------------------------+");
    }

    static void XếpTăngDầnTheoCânNặng() {
        for (int i = 0; i < mảng.length; i++) {
            for (int j = i + 1; j > mảng.length; j++) {
                var logic = mảng[i].CânNặng < mảng[j].CânNặng;

                if// nếu
                (!logic)// logic sai, không thỏa mãn
                {
                    ThúCưng tạm = mảng[i];
                    mảng[i] = mảng[j];
                    mảng[j] = tạm;
                }
            }
        }

        out.print("\n Đã sắp xếp Tăng dần theo Cân Nặng: ");
        Xuất();
    }

    static void PhânLoạiTheoGiớiTính() {

        // Mảng chứa dữ liệu thống kê
        int[] sl = new int[mảng.length]; // mối phần tử = 0

        for (int i = 0; i < sl.length; i++) {
            sl[i] = 1;
        }

        // Tinh chỉnh dữ liệu thống kê
        for (int i = 0; i < mảng.length; i++) {
            for (int j = i + 1; j < mảng.length; j++) {
                var i_j_cùng_loại = (mảng[i].GiớiTính == mảng[j].GiớiTính);

                if// nếu
                (i_j_cùng_loại && sl[j] != 0) {
                    sl[i]++;
                    sl[j]--;
                }
            }
        }

        // In dữ liệu thống kê, phân loại ra màn hình
        for (int i = 0; i < sl.length; i++) {
            if (sl[i] != 0) {
                // out.printf("Nhóm máu A có 3 bạn.");
                out.printf("\n Giới Tính %s có %d con.",  
                                            sl[i], mảng[i].GiớiTính ? "Đực"  : "Cái");
            }
        }
    }

    public static void MMA() {
        float min;
        float max;
        float sum; // tổng
        float avg; // trung_bình;

        min = mảng[0].Tuổi;
        max = mảng[0].Tuổi;
        sum = 0.0f;
        avg = 0.0f;

        for (ThúCưng sv : mảng) {
            if (min > sv.Tuổi)
                min = sv.Tuổi;
            if (max < sv.Tuổi)
                max = sv.Tuổi;

            sum += sv.Tuổi;
        }
        avg = sum / mảng.length;

        out.printf("\n Tuổi Nhỏ Nhất: %.2f", min);
        out.printf("\n Tuổi Lớn Nhất: %.2f", max);
        out.printf("\n Tuổi trung bình: %.2f", avg);
    }

    public static void Thêm() {
        // - Tạo mảng mới có độ dài lớn hơn độ dài mảng cũ (1 đơn vị)
        // - Copy dữ liệu của mảng cũ sang
        // - Khởi tạo phần tử mới,
        // - Lưu phần tử mới vào cuối mảng mới
        // - Gán mảng mới vào mảng cũ

        // 1. Tạo mảng mới có độ dài lớn hơn
        ThúCưng[] mảng_mới = new ThúCưng[mảng.length + 1];

        // 2. Copy dữ liệu của mảng cũ sang:
        for (int i = 0; i < mảng.length; i++) {
            mảng_mới[i] = mảng[i];
        }

        // 3. Khởi tạo phần tử mới
        var scan = new Scanner(System.in);

        var tc = new ThúCưng();
        out.printf("\n Nhập dữ liệu cho phần tử mới: ");
        // Nhập tên
            out.print("\n Nhập tên: ");
            tc.Tên = scan.next();
            // scan.close();

            // Nhập năm
            out.print("\n Nhập Tuổi của PET: ");
            tc.Tuổi = scan.nextInt();

            // Nhập điểm
            out.print("\n Nhập Cân Nặng: ");
            tc.CânNặng = scan.nextFloat();

            // Nhập nhóm
            out.print("\n Nhập nhóm máu(A, B, O): ");
            tc.NhómMáu = scan.next().charAt(0);

            // Nhập giới
            out.print("\n Giới tính (1=Đực/0=Cái): ");
            tc.GiớiTính = scan.nextBoolean(); // Java không cho chuyển đổi qua lại giữa bool và
                                                      // int
        // 4. Đẩy sinh viên mới vào cuối của mảng mới
        mảng_mới[mảng.length] = tc;

        mảng = mảng_mới;

        out.print("\n Danh sách thú cưng sau khi thêm mới:");
        Xuất();

    }

    public static void Sửa() {
        // hiện lại
        Bảng();

        var scan = new Scanner(System.in);
        out.print("\n Chọn số thứ tự để sửa:");
        int stt = scan.nextInt();

        int chỉ_số_cũ = stt - 1;

        var tc = new ThúCưng();
        out.printf("\n Cập nhật dữ liệu cho phần tử mảng[%d]: ", chỉ_số_cũ);
            // Nhập tên
            out.print("\n Nhập tên: ");
            tc.Tên = scan.next();
            // scan.close();

            // Nhập năm
            out.print("\n Nhập Tuổi của PET: ");
            tc.Tuổi = scan.nextInt();

            // Nhập điểm
            out.print("\n Nhập Cân Nặng: ");
            tc.CânNặng = scan.nextFloat();

            // Nhập nhóm
            out.print("\n Nhập nhóm máu(A, B, O): ");
            tc.NhómMáu = scan.next().charAt(0);

            // Nhập giới
            out.print("\n Giới tính (true=Đực/false=Cái): ");
            tc.GiớiTính = scan.nextBoolean(); // Java không cho chuyển đổi qua lại giữa bool và
                                                      // int

        // Lưu dữ liệu mới của sinh viên vào vị trí cũ
        mảng[chỉ_số_cũ] = tc;

        out.print("\n Danh sách sinh viên sau khi sửa: ");

        Bảng();

    }

    public static void Xóa() {
        // hiện lại
        Bảng();

        var scan = new Scanner(System.in);
        out.print("\n Chọn số thứ tự để xóa:");
        int stt = scan.nextInt();

        int chỉ_số_cũ = stt - 1;

        int độ_dài_mới = mảng.length - 1;

        // @todo độ dài mới <= 1 thì sao ?

        ThúCưng[] mảng_mới = new ThúCưng[độ_dài_mới];

        // Copy dữ liệu mảng cũ sang mảng mới, trừ phần tử muốn xóa
        for (int i = 0; i < mảng_mới.length; i++) {

            if (i < chỉ_số_cũ)
                // Copy những phần tử đứng trước chỉ số cũ
                mảng_mới[i] = mảng[i];
            else
                // Copy những phần tử đứng sau chỉ số cũ
                mảng_mới[i] = mảng[i + 1];
        }

        mảng = mảng_mới;

        out.print("\n Danh sách sau khi xóa: ");
        Bảng();
    }

    public static void Tìm() {
        // thân hàm
        out.print("\n Đang tìm kiếm....");
    }

//     /**
//      * @abstract Lưu dữ liệu mảng vào tệp, với định dạng JSON
//      *           Các dị thường có thể xảy ra:
//      *           -UnsupportedEncodingException: Chuỗi kí tự sử dụng lược đồ mã hóa
//      *           không hỗ trợ
//      *           -FileNotFoundException: Không tìm thấy tệp trên ổ cứng
//      *           Khi nhập đường dẫn tệp file từ Terminal/Console thì nên
//      *           dùng dấu suộc trái '/' để biểu diễn. Đỡ bị lỗi
//      *           FileNotFoundException
//      */
//     public static void GhiFileJSON() {

//         // Chuyển đổi mảng Java Array sang chuỗi Java String JSON
//         Gson gson = new Gson();
//         String jsonContent = gson.toJson(mảng);
//         // out.println(jsonContent);

//         // Đối tượng chịu trách nhiệm viết/ghi
//         // nội dung JSON tiếng Việt vào tệp/file trên ổ cứng
//         Writer writer;
//         try {
//             // Đường dẫn tĩnh để test nhanh
//             String filePath = "C:\\Users\\Public\\mang.json";

//             // Đường dẫn động nhập từ bàn phím:
//             var scan = new Scanner(System.in);
//             out.print("\n Nhập đường dẫn tệp file cần ghi dữ liệu: ");
//             filePath = scan.next();
//             // ví dụ: c:/users/public/mang-sinhvien.json

//             writer = new BufferedWriter(
//                     new OutputStreamWriter(
//                             new FileOutputStream(filePath),
//                             "UTF-8"));
//             writer.write(jsonContent);
//             writer.flush();
//             writer.close(); // Viết xong phải đóng nó lại nếu không là công cốc !
//                             // Đến lúc mở tệp ra lại chẳng thấy có dữ liệu nào được viết vào

//         } catch (Exception ex) {
//             out.print("\n Lỗi tệp file hoặc mã hóa bộ kí tự UTF8: ");
//             ex.printStackTrace();
//         }
//         // finally {
//         // writer.close();
//         // }

//         System.out.println("\n Đã ghi file JSON");
//     }

//     /**
//      * @abstract Đọc dữ liệu tệp JSON và chuyển đổi nó thành mảng
//      *           Các dị thường có thể xảy ra:
//      *           -UnsupportedEncodingException: Chuỗi kí tự sử dụng lược đồ mã hóa
//      *           không hỗ trợ
//      *           -FileNotFoundException: Không tìm thấy tệp trên ổ cứng
//      * 
//      *           Khi nhập đường dẫn tệp file từ Terminal/Console thì nên
//      *           dùng dấu suộc trái '/' để biểu diễn. Đỡ bị lỗi
//      *           FileNotFoundException
//      */
//     public static void ĐọcFileJSON() {
//         Gson gson = new Gson();

//         try {
//             // Đường dẫn tĩnh để test nhanh
//             String filePath = "C:\\Users\\Public\\mang-sinhvien.json";

//             // Đường dẫn động nhập từ bàn phím:
//             var scan = new Scanner(System.in);
//             out.print("\n Nhập đường dẫn tệp file cần đọc dữ liệu: ");
//             filePath = scan.next();
//             // ví dụ: c:/users/public/mang-sinhvien.json

//             JsonReader reader = new JsonReader(new BufferedReader(
//                     new InputStreamReader(
//                             new FileInputStream(filePath),
//                             "UTF-8")));

//             mảng = gson.fromJson(reader, ThúCưng[].class);

//             Xuất();
//         } catch (Exception e) {
//             out.print("\n Lỗi tệp file hoặc mã hóa bộ kí tự UTF8: ");
//             e.printStackTrace();
//         }
//     }

 }
// kết thúc lớp