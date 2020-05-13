package core.api.generate.springapigenerate.api;

import id.co.ptap.circleaf.core.dto.ApiResponse;
import core.api.generate.springapigenerate.model.Table10;
import core.api.generate.springapigenerate.service.Table10Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/table10")
public class Table10RestController {

    final static Logger logger = Logger.getLogger(Table10RestController.class);

    @Autowired
    private Table10Service table10Service;

    @GetMapping({"/list"})
    @PreAuthorize("@securityConfigService.hasPermission()")
    public ResponseEntity<ApiResponse> list() {
        logger.info("Call list function");
        ApiResponse<List<Table10>> apiResponse = this.table10Service.doView();
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(apiResponse);
    }

    @RequestMapping(value = "/create",
            produces = "application/json",
            method= RequestMethod.POST)
    @PreAuthorize("@securityConfigService.hasPermission()")
    public ResponseEntity<ApiResponse> create(@RequestBody Table10 table10) {
        logger.info("Call create function");
        ApiResponse apiResponse = this.table10Service.doAdd(table10);
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(apiResponse);
    }

    @PostMapping("/edit")
    @PreAuthorize("@securityConfigService.hasPermission()")
    public ResponseEntity<ApiResponse> edit(@RequestBody Table10 table10) {
        logger.info("Call edit function");
        ApiResponse apiResponse = this.table10Service.doEdit(table10);
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(apiResponse);
    }

    @PostMapping("/remove")
    @PreAuthorize("@securityConfigService.hasPermission()")
    public ResponseEntity<ApiResponse> remove(@RequestBody List<Table10> table10List) {
        logger.info("Call remove function");
        ApiResponse apiResponse = this.table10Service.doDelete(table10List);
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(apiResponse);
    }

    @PostMapping("/preview")
    @PreAuthorize("@securityConfigService.hasPermission()")
    public ResponseEntity<ApiResponse> preview(@RequestBody Table10 table10) {
        logger.info("Call preview function");
        ApiResponse apiResponse = this.table10Service.doPreview(table10);
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(apiResponse);
    }

} 