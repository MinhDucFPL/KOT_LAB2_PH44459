package com.kot104.kot_lab2

class SinhVien(
    var tenSV: String,
    var mSSV: String,
    var diemTB: Float,
    var daTotNghiep: Boolean? = null,
    var tuoi: Int? = null
)

fun main() {
    val sv1 = SinhVien(
        tenSV = "Lê Minh Đức",
        mSSV = "PH44459",
        diemTB = 9.2f,
        daTotNghiep = true,
        tuoi = 21
    )
    val sv2 = SinhVien(
        tenSV = "Vũ Minh Quân",
        mSSV = "PH44064",
        diemTB = 8.2f,
        daTotNghiep = true,
        tuoi = 20
    )


    var danhSachSV = mutableListOf<SinhVien>()
    danhSachSV.add(sv1)
    danhSachSV.add(sv2)
    while (true) {
        println("\n--- Menu quản lý sinh viên ---")
        println("1. Thêm sinh viên")
        println("2. Sửa thông tin sinh viên")
        println("3. Xóa sinh viên")
        println("4. Xem danh sách sinh viên")
        println("5. Thoát")

        print("Nhập lựa chọn của bạn: ")
        val luaChon = readLine()?.toIntOrNull() ?: 0

        when (luaChon) {
            1 -> themSinhVien(danhSachSV)
            2 -> suaThongTinSinhVien(danhSachSV)
            3 -> xoaSinhVien(danhSachSV)
            4 -> xemDanhSachSinhVien(danhSachSV)
            5 -> break
            else -> println("Lựa chọn không hợp lệ!")
        }
    }

    println("Thoát chương trình!")
}

fun themSinhVien(danhSachSV: MutableList<SinhVien>) {
    print("Nhập tên sinh viên: ")
    val tenSV = readLine() ?: ""
    print("Nhập MSSV: ")
    val mSSV = readLine() ?: ""
    print("Nhập điểm TB: ")
    val diemTB = readLine()?.toFloatOrNull() ?: 0.0f
    print("Đã tốt nghiệp (true/false): ")
    val daTotNghiep = readLine()?.toBoolean()?: true
    print("Nhập tuổi (có thể bỏ trống): ")
    val tuoi = readLine()?.toIntOrNull()

    val sinhVienMoi = SinhVien(tenSV, mSSV, diemTB, daTotNghiep, tuoi)
    danhSachSV.add(sinhVienMoi)
    println("Thêm sinh viên thành công!")
}

fun suaThongTinSinhVien(danhSachSV: MutableList<SinhVien>) {
    if (danhSachSV.isEmpty()) {
        println("Danh sách sinh viên trống!")
        return
    }

    print("Nhập MSSV của sinh viên cần sửa: ")
    val mSSV = readLine() ?: ""

    val sinhVienIndex = danhSachSV.indexOfFirst { it.mSSV == mSSV }
    if (sinhVienIndex == -1) {
        println("MSSV không hợp lệ!")
        return
    }

    val sinhVien = danhSachSV[sinhVienIndex]
    print("Nhập tên mới (bỏ trống nếu không muốn sửa): ")
    val tenSVMoi = readLine()
    if (tenSVMoi != null && tenSVMoi.isNotEmpty()) {  // Check for null first
        sinhVien.tenSV = tenSVMoi
    }

    print("Nhập điểm TB mới (bỏ trống nếu không muốn sửa): ")
    val diemTBMoi = readLine()?.toFloatOrNull()
    if (diemTBMoi != null) {
        sinhVien.diemTB = diemTBMoi
    }

    print("Cập nhật trạng thái tốt nghiệp (true/false, bỏ trống nếu không muốn sửa): ")
    val daTotNghiepMoi = readLine().toBoolean()

    if (daTotNghiepMoi != null) {
        sinhVien.daTotNghiep = daTotNghiepMoi
    }

    print("Nhập tuổi mới (bỏ trống nếu không muốn sửa): ")
    val tuoiMoi = readLine()?.toIntOrNull()
    if (tuoiMoi != null) {
        sinhVien.tuoi = tuoiMoi
    }

    println("Cập nhật thông tin sinh viên thành công!")
}
fun xoaSinhVien(danhSachSV: MutableList<SinhVien>) {
    if (danhSachSV.isEmpty()) {
        println("Danh sách sinh viên trống!")
        return
    }

    print("Nhập MSSV của sinh viên cần xóa: ")
    val mSSV = readLine() ?: ""

    val sinhVienIndex = danhSachSV.indexOfFirst { it.mSSV == mSSV }
    if (sinhVienIndex == -1) {
        println("MSSV không hợp lệ!")
        return
    }

    println("Bạn có chắc chắn muốn xóa sinh viên này không? (Y/N)")
    val xacNhan = readLine()?.uppercase() ?: ""

    if (xacNhan == "Y") {
        danhSachSV.removeAt(sinhVienIndex)
        println("Xóa sinh viên thành công!")
    } else {
        println("Hủy bỏ xóa sinh viên.")
    }
}
fun xemDanhSachSinhVien(danhSachSV: MutableList<SinhVien>) {
    if (danhSachSV.isEmpty()) {
        println("Danh sách sinh viên trống!")
        return
    }

    println("\n--- Danh sách sinh viên ---")
    for (sinhVien in danhSachSV) {
        println("Tên: ${sinhVien.tenSV}")
        println("MSSV: ${sinhVien.mSSV}")
        println("Điểm TB: ${sinhVien.diemTB}")
        println("Đã tốt nghiệp: ${sinhVien.daTotNghiep ?: "Chưa có thông tin"}")
        println("Tuổi: ${sinhVien.tuoi ?: "Chưa có thông tin"}")
        println("---------------------------------------")
    }
}