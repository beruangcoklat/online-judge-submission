package main

import (
    "bufio"
    "fmt"
    "io"
    "os"
    "strings"
    "strconv"
)

/*
 * Complete the 'timeConversion' function below.
 *
 * The function is expected to return a STRING.
 * The function accepts STRING s as parameter.
 */

func timeConversion(s string) string {
    hour, _ := strconv.Atoi(s[:2])
    minute := s[3:5]
    second := s[6:8]
    dayType := s[8:]
    
    if (dayType == "PM" && hour < 12) || 
        (dayType == "AM" && hour == 12) {
        hour += 12
        hour %= 24
    }
    
    hourStr := ""
    if hour < 10 {
        hourStr = "0" + strconv.Itoa(hour)
    } else {
        hourStr = strconv.Itoa(hour)
    }
    return fmt.Sprintf("%v:%v:%v", hourStr, minute, second)
}

func main() {
    reader := bufio.NewReaderSize(os.Stdin, 16 * 1024 * 1024)

    stdout, err := os.Create(os.Getenv("OUTPUT_PATH"))
    checkError(err)

    defer stdout.Close()

    writer := bufio.NewWriterSize(stdout, 16 * 1024 * 1024)

    s := readLine(reader)

    result := timeConversion(s)

    fmt.Fprintf(writer, "%s\n", result)

    writer.Flush()
}

func readLine(reader *bufio.Reader) string {
    str, _, err := reader.ReadLine()
    if err == io.EOF {
        return ""
    }

    return strings.TrimRight(string(str), "\r\n")
}

func checkError(err error) {
    if err != nil {
        panic(err)
    }
}

