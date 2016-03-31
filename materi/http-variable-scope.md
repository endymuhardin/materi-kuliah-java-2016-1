# Scope Variabel dalam HTTP #

* Scope Variabel : umur (lifetime) variabel atau dimana variabel bisa digunakan (visibility)

Scope variabel dalam aplikasi web

* request : variabel hanya berlaku dalam satu request. Request berikutnya tidak dapat mengakses variabel di request pertama.

* session : variabel berlaku selama session hidup. Session hidup selama :

    * di sisi client : browser belum ditutup
    * di sisi server : 

        * session belum timeout
        * session belum dihapus

* aplikasi / context (istilah Java) : variabel ada selama aplikasi berjalan. Akan terhapus pada saat aplikasi di-restart. Scope ini tidak ada di PHP, solusinya simpan di database.

## Penggunaan (Use Case) Scope Variabel ##

* Use Case Scope Request

	* form input
	* variabel di link

* Use Case Scope Session

    * mengecek login
    * halaman yang terakhir diakses
    * menampilkan info user yang sedang login

* Use Case Scope Aplikasi

	* Uptime aplikasi
	* Data yang dishare semua user. Contoh: logo, versi aplikasi, visitor, jumlah klik