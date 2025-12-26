package com.project.lovableproject.demo.service;

import com.project.lovableproject.demo.dto.project.FileContentResponse;
import com.project.lovableproject.demo.dto.project.FileNode;
import org.jspecify.annotations.Nullable;

import java.util.List;

public interface FileService {
     List<FileNode> getFileTree(Long projectId, Long userId);

     FileContentResponse getFileContent(Long projectId, String path, Long userId);
}
