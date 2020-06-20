package com.scube.rm.adapter.client;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.scube.rm.common.WebAdapter;
import com.scube.rm.core.port.in.DocumentContentUseCase;

import lombok.RequiredArgsConstructor;


@WebAdapter
@RestController
@RequiredArgsConstructor
public class DocumentContentController {
	
	private final DocumentContentUseCase documentContentUseCase;
	
	@PostMapping(path = "/files/{fileId}")
	public ResponseEntity<?> setContent(@PathVariable("fileId") Long id, @RequestParam("file") MultipartFile file) {
		documentContentUseCase.setContent(id, file);
		return null;
	}
	
	@GetMapping(path="/files/{fileId}")
	public ResponseEntity<?> getContent(@PathVariable("fileId") Long id) {
		documentContentUseCase.getContent(id);
		return null;
	}
	
	@DeleteMapping(path="/files/{fileId}")
	public ResponseEntity<?> unsetContent(@PathVariable("fileId") Long id) {
		documentContentUseCase.unsetContent(id);
		return null;
	}
	
	@GetMapping(path = "/files/search/{queryString}")
	public ResponseEntity<?> searchContent(@PathVariable("queryString") String queryString) {
		documentContentUseCase.searchContent(queryString);
		return null;
	}

}
