package core.api.generate.springapigenerate.api;

import id.co.ptap.circleaf.core.dto.ApiResponse;
import core.api.generate.springapigenerate.model.Table09;
import core.api.generate.springapigenerate.service.Table09Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/table09")
public class Table09RestController {

    final static Logger logger = Logger.getLogger(Table09RestController.class);

    @Autowired
    private Table09Service table09Service;

    @GetMapping({"/list"})
    @PreAuthorize("@securityConfigService.hasPermission()")
    public ResponseEntity<ApiResponse> list() {
        logger.info("Call list function");
        ApiResponse<List<Table09>> apiResponse = this.table09Service.doView();
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(apiResponse);
    }

    @RequestMapping(value = "/create",
            produces = "application/json",
            method= RequestMethod.POST)
    @PreAuthorize("@securityConfigService.hasPermission()")
    public ResponseEntity<ApiResponse> create(@RequestBody Table09 table09) {
        logger.info("Call create function");
        ApiResponse apiResponse = this.table09Service.doAdd(table09);
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(apiResponse);
    }

    @PostMapping("/edit")
    @PreAuthorize("@securityConfigService.hasPermission()")
    public ResponseEntity<ApiResponse> edit(@RequestBody Table09 table09) {
        logger.info("Call edit function");
        ApiResponse apiResponse = this.table09Service.doEdit(table09);
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(apiResponse);
    }

    @PostMapping("/remove")
    @PreAuthorize("@securityConfigService.hasPermission()")
    public ResponseEntity<ApiResponse> remove(@RequestBody List<Table09> table09List) {
        logger.info("Call remove function");
        ApiResponse apiResponse = this.table09Service.doDelete(table09List);
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(apiResponse);
    }

    @PostMapping("/preview")
    @PreAuthorize("@securityConfigService.hasPermission()")
    public ResponseEntity<ApiResponse> preview(@RequestBody Table09 table09) {
        logger.info("Call preview function");
        ApiResponse apiResponse = this.table09Service.doPreview(table09);
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(apiResponse);
    }

} 