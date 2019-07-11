package frame.swagger.withSpringfox;


import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
 

@Controller
@RestController
@RequestMapping("/person")
@Api(tags = "人员接口",description="人员文档说明",hidden=true)
public class PersonController {
 
	@Autowired
	private PersonService personService;
//	,method=RequestMethod.POST
	@RequestMapping(value="selectAll",method=GET)
	@ApiOperation(value="查询所有的人员",notes="查询所有的人员接口说明")
	@ApiImplicitParams({
		@ApiImplicitParam(name="month",value="年月，格式为：201801",dataType="String", paramType = "query"),
		@ApiImplicitParam(name="pageSize",value="页码",dataType="String", paramType = "query"),
		@ApiImplicitParam(name="pageNum",value="每页条数",dataType="String", paramType = "query"),
		@ApiImplicitParam(name="empName",value="业务员名称",dataType="String", paramType = "query"),
		@ApiImplicitParam(name="orderType",value="排序类型",dataType="String", paramType = "query"),
	})
	@ApiResponse(response=Person.class, code = 200, message = "接口返回对象参数")
	public List<Person> selectAll(HttpServletRequest request) {
		List<Person> list = personService.selectAll();
		return list;
	}
	@RequestMapping(value="abc",method=GET)
	public String home() {
		return "home";
	}
//	@RequestMapping(value="findById",method=RequestMethod.POST)
//	@ResponseBody
//	public Person findById(Integer id) {
//		Person person = personService.findById(id);
//		return person;
//	}
	
}
