#! /bin/bash
find ./test_files -type f -name "*.txt" | while read filePath
do
    java -cp build/classes/main/ snow.Main "$filePath" "$filePath.actual"
    diff "$filePath.actual" "$filePath.expected" > /dev/null
    if [ $? -ne 0 ]
    then
        echo Error in "$filePath"
    else
        rm -f "$filePath.actual"
    fi
done
