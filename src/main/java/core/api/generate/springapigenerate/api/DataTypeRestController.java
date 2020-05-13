package core.api.generate.springapigenerate.api;

import id.co.ptap.circleaf.core.dto.ApiResponse;
import core.api.generate.springapigenerate.model.DataType;
import core.api.generate.springapigenerate.service.DataTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/datatype")
public class DataTypeRestController {

    final static Logger logger = Logger.getLogger(DataTypeRestController.class);

    @Autowired
    private DataTypeService dataTypeService;

    @GetMapping({"/list"})
    @PreAuthorize("@securityConfigService.hasPermission()")
    public ResponseEntity<ApiResponse> list() {
        logger.info("Call list function");
        ApiResponse<List<DataType>> apiResponse = this.dataTypeService.doView();
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(apiResponse);
    }

    @RequestMapping(value = "/create",
            produces = "application/json",
            method= RequestMethod.POST)
    @PreAuthorize("@securityConfigService.hasPermission()")
    public ResponseEntity<ApiResponse> create(@RequestBody DataType dataType) {
        logger.info("Call create function");
        ApiResponse apiResponse = this.dataTypeService.doAdd(dataType);
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(apiResponse);
    }

    @PostMapping("/edit")
    @PreAuthorize("@securityConfigService.hasPermission()")
    public ResponseEntity<ApiResponse> edit(@RequestBody DataType dataType) {
        logger.info("Call edit function");
        ApiResponse apiResponse = this.dataTypeService.doEdit(dataType);
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(apiResponse);
    }

    @PostMapping("/remove")
    @PreAuthorize("@securityConfigService.hasPermission()")
    public ResponseEntity<ApiResponse> remove(@RequestBody List<DataType> dataTypeList) {
        logger.info("Call remove function");
        ApiResponse apiResponse = this.dataTypeService.doDelete(dataTypeList);
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(apiResponse);
    }

    @PostMapping("/preview")
    @PreAuthorize("@securityConfigService.hasPermission()")
    public ResponseEntity<ApiResponse> preview(@RequestBody DataType dataType) {
        logger.info("Call preview function");
        ApiResponse apiResponse = this.dataTypeService.doPreview(dataType);
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(apiResponse);
    }

} 