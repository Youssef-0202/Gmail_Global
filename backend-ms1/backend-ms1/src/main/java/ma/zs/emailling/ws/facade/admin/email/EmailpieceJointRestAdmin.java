package  ma.zs.emailling.ws.facade.admin.email;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.emailling.bean.core.email.EmailpieceJoint;
import ma.zs.emailling.dao.criteria.core.email.EmailpieceJointCriteria;
import ma.zs.emailling.service.facade.admin.email.EmailpieceJointAdminService;
import ma.zs.emailling.ws.converter.email.EmailpieceJointConverter;
import ma.zs.emailling.ws.dto.email.EmailpieceJointDto;
import ma.zs.emailling.zynerator.controller.AbstractController;
import ma.zs.emailling.zynerator.dto.AuditEntityDto;
import ma.zs.emailling.zynerator.util.PaginatedList;


import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import ma.zs.emailling.zynerator.process.Result;


import org.springframework.web.multipart.MultipartFile;
import ma.zs.emailling.zynerator.dto.FileTempDto;

@RestController
@RequestMapping("/api/admin/emailpieceJoint/")
public class EmailpieceJointRestAdmin  extends AbstractController<EmailpieceJoint, EmailpieceJointDto, EmailpieceJointCriteria, EmailpieceJointAdminService, EmailpieceJointConverter> {



    @Operation(summary = "upload one emailpieceJoint")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple emailpieceJoints")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all emailpieceJoints")
    @GetMapping("")
    public ResponseEntity<List<EmailpieceJointDto>> findAll() throws Exception {
        return super.findAll();
    }



    @Operation(summary = "Saves the specified  emailpieceJoint")
    @PostMapping("")
    public ResponseEntity<EmailpieceJointDto> save(@RequestBody EmailpieceJointDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  emailpieceJoint")
    @PutMapping("")
    public ResponseEntity<EmailpieceJointDto> update(@RequestBody EmailpieceJointDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of emailpieceJoint")
    @PostMapping("multiple")
    public ResponseEntity<List<EmailpieceJointDto>> delete(@RequestBody List<EmailpieceJointDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified emailpieceJoint")
    @DeleteMapping("")
    public ResponseEntity<EmailpieceJointDto> delete(@RequestBody EmailpieceJointDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified emailpieceJoint")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple emailpieceJoints by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @Operation(summary = "find by email id")
    @GetMapping("email/id/{id}")
    public List<EmailpieceJointDto> findByEmailId(@PathVariable Long id){
        return findDtos(service.findByEmailId(id));
    }
    @Operation(summary = "delete by email id")
    @DeleteMapping("email/id/{id}")
    public int deleteByEmailId(@PathVariable Long id){
        return service.deleteByEmailId(id);
    }
    @Operation(summary = "find by typeContenu id")
    @GetMapping("typeContenu/id/{id}")
    public List<EmailpieceJointDto> findByTypeContenuId(@PathVariable Long id){
        return findDtos(service.findByTypeContenuId(id));
    }
    @Operation(summary = "delete by typeContenu id")
    @DeleteMapping("typeContenu/id/{id}")
    public int deleteByTypeContenuId(@PathVariable Long id){
        return service.deleteByTypeContenuId(id);
    }

    @Operation(summary = "Finds a emailpieceJoint and associated list by id")
    @GetMapping("id/{id}")
    public ResponseEntity<EmailpieceJointDto> findById(@PathVariable Long id) {
        return super.findById(id);
    }

    @Operation(summary = "Finds emailpieceJoints by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<EmailpieceJointDto>> findByCriteria(@RequestBody EmailpieceJointCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated emailpieceJoints by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody EmailpieceJointCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports emailpieceJoints by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody EmailpieceJointCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets emailpieceJoint data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody EmailpieceJointCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public EmailpieceJointRestAdmin (EmailpieceJointAdminService service, EmailpieceJointConverter converter) {
        super(service, converter);
    }




}
