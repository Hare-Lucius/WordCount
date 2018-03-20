wc.exe -c
wc.exe -c test.c
wc.exe -c -w test.c
wc.exe -c -w test.c -o output1.txt
wc.exe -c -w -l test.c -o output2.txt
wc.exe -c -w -l -a test1.c -o output3.txt
wc.exe -s -c -w -l -a *.c -o output4.txt
wc.exe -s -c -w -l -a C:\Users\lby82\Desktop\test\*.c -o output5.txt
wc.exe -c -w -l -a test2.c -e stoplist.txt -o output6.txt
wc.exe -s -c -w -l -a *.c -e stoplist.txt -o output7.txt
pause