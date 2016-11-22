/*
 * Septiyawan Nifthoh Syafi'i
 * 12141383
 */
package com.septiyawan.app12141383;

/**
 *
 * @author Wawan
 */

import java.util.Scanner;


public class tebakAngka {
   
    String nama;
    byte level = 1;
    byte giliran = 5, sisa;
    short tebak;
    short banyak = 0;
    int angka = 5;
    int random, nilai = 0;
    char jwb, pilih;
    int total = 0, x=0;
    int[] history = new int[5];
    public int Level(){
        return level*100;
    }
    
    public void hasilmenebak() {
      sisa--;
      banyak++;
      
      
        System.out.println("Tebakan anda : " + tebak);
        if (tebak<angka){
            System.out.print("Tebakan Anda telalu kecil! ");
        }
        if (tebak>angka){
            System.out.println("Tebakan Anda telalu besar!");
        }
        if (tebak==angka){
            System.out.print("Selamat Anda berhasil menebak sebanyak " + banyak + " kali tebakan");
        }
        
        if (sisa>0&&tebak!=angka){
            System.out.println("Anda mempunyai kesempatan " + sisa + " kali lagi.");
        }
        if (sisa<=0) {
            System.out.println("Game Over");
        }
    }
    
    public void Nilai() {
        if (banyak>0){
            nilai = 100*level;
        }
        if (banyak>1){
            nilai = 70*level;
        }
        if (banyak>2){
            nilai = 50*level;
        }
        if (banyak>3){
            nilai = 30*level;
        }
        if (banyak>4){
            nilai = 0*level;
        }
        System.out.println();
        System.out.println(nama + "\t: " + nilai);
        total=total+nilai;
    }
    
    public void History(){
        history [x] = total;
    }
    
    public void totalNilai(){
        System.out.println("Total score anda : " + total);        
    }
    
    public void Reset(){        
    level = 1;
    giliran = 5;
    banyak=0;
    total=0;
    }
    
    public static void main(String[] args) {
        tebakAngka main = new tebakAngka();
        System.out.println("Game Tebak Angka");
        System.out.println("Septiyawan Nifthoh Syafi'i");
        System.out.println("12141383");
        System.out.println("================================");
        
        Scanner inputString = new Scanner(System.in);
        Scanner inputAngka = new Scanner(System.in);
        
        do{
        System.out.println("Masukkan nama Anda untuk memulai game atau tekan 'Y' untuk keluar, kemudian tekan enter : ");
        main.nama=inputString.nextLine();
        System.out.println("Selamat Datang." + main.nama);
        
          if ("T".equals(main.nama)){
              break;
          }
          else{
            do {
            main.random = (short) (Math.random()*main.Level());
            System.out.println("# Level " + main.level);  
            System.out.println("Selamat datang " + main.nama);  
            System.out.println("Silakan tebak angka antara 1 s/d " + main.Level());    
            System.out.println("Anda memiliki kesempatan menebak " + main.giliran + " kali"); 
            main.sisa=main.giliran;
            
            do{
                System.out.println();   
                System.out.println("Masukkan Tebakan : "); 
                main.tebak = inputAngka.nextShort();
                main.hasilmenebak();
            }while(main.tebak!=main.random&&main.sisa>0);
            
            
            if (main.tebak==main.random){
                main.Nilai();
                System.out.println("Apakah anda ingin melanjutkan ke level selanjutnya ? (y/t)");
                main.jwb=inputString.nextLine().charAt(0);
                main.level++;
                main.banyak=0;
            }
            else {     break;}
            }while(main.jwb=='y');
            main.totalNilai();
            main.Reset();
          }
        }while(!"T".equals(main.nama)); 
        
    }        
}