package com.putrenkov.springmvc.util;


import com.putrenkov.springmvc.model.FileBucket;
import com.putrenkov.springmvc.model.StatisticsFile;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class FileHelper {
    private static final Logger log = Logger.getLogger(FileHelper.class);
    public static File createFile(String fileName, String content) throws IOException {
        File file = new File(fileName);
        FileUtils.writeStringToFile(file, content);
        return file;
    }

    public static String getContent(FileBucket fileBucket) throws IOException {
        ByteArrayInputStream stream = new   ByteArrayInputStream(fileBucket.getFile().getBytes());
        return IOUtils.toString(stream, "UTF-8");
    }

    public static List<StatisticsFile> getFilesByCondition(String condition, List<StatisticsFile> allStatisticsFiles) {
        log.error(condition);
        switch (condition) {
            case "moreTenLines" : return getFilesMoreTenLines(allStatisticsFiles);
        }
        return Collections.emptyList();
    }

    private static List<StatisticsFile> getFilesMoreTenLines(List<StatisticsFile> allStatisticsFiles) {
        return  allStatisticsFiles.stream().filter(statFile -> statFile.getNumberOfLines() >= 10).collect(Collectors.toList());
    }

}
