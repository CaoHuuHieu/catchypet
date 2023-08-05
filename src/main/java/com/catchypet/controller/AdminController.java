package com.catchypet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.catchypet.model.entity.CategoryEntity;
import com.catchypet.model.entity.NewEntity;
import com.catchypet.model.entity.ProductEntity;
import com.catchypet.model.entity.ServiceEntity;
import com.catchypet.model.entity.UserEntity;
import com.catchypet.request.Category;
import com.catchypet.request.NewDTO;
import com.catchypet.request.Product;
import com.catchypet.service.CategoryService;
import com.catchypet.service.NewService;
import com.catchypet.service.ProductService;
import com.catchypet.service.ServiceService;
import com.catchypet.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class AdminController {
	@Autowired
	CategoryService categoryService;
	@Autowired
	ProductService productService;
	@Autowired
	UserService userService;
	@Autowired
	ServiceService serviceService;
	@Autowired
	NewService newService;
	@Autowired
	HttpSession session;

	@GetMapping("admin/category")
	public String categoryPage(Model model) {
		List<CategoryEntity> catetegories = categoryService.getAllCategory();
		model.addAttribute("categories", catetegories);
		return "admin/category";
	}

	@GetMapping("admin/category/add")
	public String addCategoryPage(Model model) {
		model.addAttribute("category", new CategoryEntity());
		return "admin/category-add";
	}

	@GetMapping("admin/category/update/{id}")
	public String addCategoryPage(@PathVariable Long id, Model model) {
		CategoryEntity category = categoryService.findById(id);
		model.addAttribute("category", category);
		return "admin/category-add";
	}

	@PostMapping("admin/category")
	public String addCategory(@ModelAttribute("category") Category category, Model model) {
		try {
			if (category.getId() == null) {
				CategoryEntity categoryEntity = categoryService.save(category);
				category.setId(categoryEntity.getId());
				session.setAttribute("message", new Message("Đã thêm mới danh mục!", "success"));
			} else {
				categoryService.update(category.getId(), category);
				session.setAttribute("message", new Message("Đã cập nhật danh mục!", "success"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("message", new Message("Đã có lỗi xảy ra!", "error"));
		}
		model.addAttribute("category", category);
		return "admin/category-add";

	}

	@GetMapping("admin/category/delete/{id}")
	public String deleteCategory(@PathVariable Long id) {
		try {
			categoryService.delete(id);
			session.setAttribute("message", new Message("Đã xóa danh mục!", "success"));
		} catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("message", new Message("Đã xãy ra lỗi!", "error"));
		}
		return "redirect:/admin/category";
	}

	@GetMapping({ "admin/products/{status}", "admin/products" })
	public String productsPage(Model model, @PathVariable(required = false) Integer status,
			@RequestParam(defaultValue = "0") int page) {
		int pageSize = 10;
		Pageable pageable = PageRequest.of(page, pageSize);
		status = status == null ? 0 : status;
		Page<ProductEntity> productPage;
		productPage = productService.getProducts(status, pageable);
		List<ProductEntity> products = productPage.getContent();
		model.addAttribute("products", products);
		model.addAttribute("currentPage", page);
		model.addAttribute("totalPages", productPage.getTotalPages());

		return "admin/product";
	}

	@GetMapping("admin/product/add")
	public String addProductPage(Model model) {
		model.addAttribute("product", new ProductEntity());
		model.addAttribute("categories", categoryService.getCategoryForProduct());
		return "admin/product-add";
	}

	@GetMapping("admin/product/update/{id}")
	public String updateProductPage(@PathVariable Long id, Model model) {
		Product product = productService.findById(id);
		model.addAttribute("categories", categoryService.getCategoryForProduct());
		model.addAttribute("product", product);
		return "admin/product-add";
	}

	@PostMapping("admin/product/add")
	public String addProduct(@ModelAttribute("product") Product product, Model model) {
		try {
			if (product.getId() == null) {
				ProductEntity productEntity = productService.save(product);
				product.setId(productEntity.getId());
				session.setAttribute("message", new Message("Đã thêm mới sản phẩm!", "success"));
			} else {
				productService.update(product);
				session.setAttribute("message", new Message("Đã cập nhật sản phẩm!", "success"));
			}

		} catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("message", new Message("Đã có lỗi xảy ra!", "error"));
		}
		model.addAttribute("categories", categoryService.getCategoryForProduct());
		model.addAttribute("product", product);
		return "admin/product-add";
	}

	@GetMapping("admin/product/delete/{id}")
	public String deleteProduct(@PathVariable Long id) {
		try {
			productService.delete(id);
			session.setAttribute("message", new Message("Đã xóa sản phẩm!", "success"));
		} catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("message", new Message("Đã xãy ra lỗi!", "error"));
		}
		return "redirect:/admin/products";

	}

	@GetMapping("login")
	public String loginPage() {
		return "login";
	}

	@GetMapping("admin/account")
	public String accountPage(Model model) {
		List<UserEntity> userEntities = userService.getAllUser();
		model.addAttribute("users", userEntities);
		return "admin/account";
	}

	@GetMapping("admin/account/lock/{id}")
	public String lockAccount(@PathVariable Long id, Model model) {
		try {
			userService.lockAccount(id);
			session.setAttribute("message", new Message("Đã khóa tài khoản!", "success"));
		} catch (Exception e) {
			session.setAttribute("message", new Message("Không tìm thấy tài khoản!", "error"));
		}
		return "redirect:/admin/account";
	}

	@GetMapping("admin/account/unlock/{id}")
	public String unlockAccount(@PathVariable Long id, Model model) {
		try {
			userService.unlockAccount(id);
			session.setAttribute("message", new Message("Đã mở khóa tài khoản!", "success"));
		} catch (Exception e) {
			session.setAttribute("message", new Message("Không tìm thấy tài khoản!", "error"));
		}
		return "redirect:/admin/account";
	}

	@GetMapping("admin/account/add")
	public String addAccountPage(Model model) {
		model.addAttribute("account", new UserEntity());
		return "admin/account-add";
	}

	@GetMapping("admin/account/search")
	public String findAccount(@RequestParam String key, Model model) {
		List<UserEntity> userEntities = userService.findByUsernameContaining(key);
		model.addAttribute("users", userEntities);
		return "admin/account";
	}

	@PostMapping("admin/account")
	public String addAccount(@ModelAttribute("account") UserEntity user, Model model) {
		try {
			user = userService.save(user);
			if (user.getId() == null) {
				session.setAttribute("message", new Message("Đã thêm mới tài khoản!", "success"));
			} else {
				session.setAttribute("message", new Message("Đã cập nhật tài khoản!", "success"));
			}

		} catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("message", new Message("Đã có lỗi xảy ra!", "error"));
		}
		model.addAttribute("account", user);
		return "admin/account-add";
	}

	@GetMapping("admin/account/update/{id}")
	public String updateAccount(@PathVariable Long id, Model model) {
		model.addAttribute("account", userService.findById(id));
		return "admin/account-add";
	}

	@GetMapping("admin/new")
	public String newPage(Model model) {
		model.addAttribute("news", newService.getAllNew());
		return "admin/new";
	}

	@GetMapping("admin/new/add")
	public String addNewPage(Model model) {
		model.addAttribute("newDto", new NewDTO());
		return "admin/new-add";
	}

	@PostMapping("admin/new")
	public String addNew(@ModelAttribute("newDto") NewDTO newDto, Model model) {
		try {

			if (newDto.getId() != null) {
				NewEntity newEntity = newService.save(newDto);
				newDto.setId(newEntity.getId());
				session.setAttribute("message", new Message("Đã thêm mới bài viết!", "success"));
			} else {
				newService.update(newDto.getId(), newDto);
				session.setAttribute("message", new Message("Đã cập nhật bài viết!", "success"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("message", new Message("Đã có lỗi xãy ra!", "errer"));
		}
		model.addAttribute("newDto", newDto);
		return "admin/new-add";
	}

	@GetMapping("admin/new/update/{id}")
	public String updateNew(Model model, @PathVariable Long id) {
		NewDTO newDto = newService.getNewById(id);
		model.addAttribute("newDto", newDto);
		return "admin/new-add";
	}

	@GetMapping("admin/new/delete/{id}")
	public String deleteNew(@PathVariable Long id) {
		try {
			newService.delete(id);
			session.setAttribute("message", new Message("Đã xóa bài viết!", "success"));
		} catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("message", new Message("Đã xãy ra lỗi!", "error"));
		}
		return "redirect:/admin/new";
	}

	@GetMapping("admin/contact")
	public String contactPage() {
		return "admin/contact";
	}

	@GetMapping("admin/order")
	public String orderPage() {
		return "admin/order";
	}

	@GetMapping("admin/order/{id}")
	public String orderDetailPage(@PathVariable Long id) {
		return "admin/order-detail";
	}

	@GetMapping("admin/service")
	public String servicePage(Model model) {
		model.addAttribute("services", serviceService.getAllService());
		return "admin/service";
	}

	@GetMapping("admin/service/add")
	public String addServicePage(Model model) {
		model.addAttribute("service", new ServiceEntity());
		return "admin/service-add";
	}

	@PostMapping("admin/service/add")
	public String addService(@ModelAttribute ServiceEntity service, Model model) {
		try {
			service = serviceService.save(service);
			if (service.getId() == null) {
				session.setAttribute("message", new Message("Đã thêm mới dịch vụ!", "success"));
			} else {
				session.setAttribute("message", new Message("Đã cập nhật dịch vụ!", "success"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("message", new Message("Đã xảy ra lỗi!", "error"));
		}
		model.addAttribute("service", service);
		return "admin/service-add";
	}

	@GetMapping("admin/service/update/{id}")
	public String updateService(@PathVariable Long id, Model model) {
		model.addAttribute("service", serviceService.findById(id));
		return "admin/service-add";
	}

	@GetMapping("admin/service/delete/{id}")
	public String deleteService(@PathVariable Long id) {
		try {
			serviceService.delete(id);
			session.setAttribute("message", new Message("Đã xóa dịch vụ!", "success"));
		} catch (Exception e) {
			session.setAttribute("message", new Message("Không tìm thấy dịch vụ!", "error"));
		}
		return "redirect:/admin/service";
	}

}
