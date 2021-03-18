package hello.itemservice.web.basic;

import hello.itemservice.domain.item.Item;
import hello.itemservice.domain.item.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * templates/css가 있는 이유는 정적인 절대경로를 바로 뷰로 띄우기 위해서다.
 * 지워도 이상은 없고 직접접근할 때 Css를 포함할 뿐이다.
 */
@Controller
@RequiredArgsConstructor
@RequestMapping("/basic/items")
public class BasicItemController {

    private final ItemRepository itemRepository;

    @GetMapping
    public String items(Model model){
        List<Item> items = itemRepository.findAll();
        model.addAttribute("items",items);
        return "basic/items";
    }

    @GetMapping("/{itemId}")
    public String item(@PathVariable long itemId, Model model){
        Item item = itemRepository.findById(itemId);
        model.addAttribute("item",item);
        return "basic/item";
    }

    @GetMapping("/add")
    public String addForm(){
        return "basic/addForm";
    }

    /** int해도 상관없다고함. 도메인은 integer인데 */
    //@PostMapping("/add")
    public String addItemV1(@RequestParam String itemName,
                       @RequestParam int price,
                       @RequestParam Integer quantity,
                       Model model){
        Item item = new Item();
        item.setItemName(itemName);
        item.setPrice(price);
        item.setQuantity(quantity);
        itemRepository.save(item);

        model.addAttribute("item",item);
        return "basic/item";
    }

    /**
     *      모델 애트리뷰트가 객체생성, 세터로 지정하는 것까지 다 해준다. 그래서 그대로 지울 수 있다.
     *      모델 애트리뷰트는 여러가지 용도가있는데, 모델 객체 만들어 주는 것, 자동으로 모델에 넣어주는
     *      역할을 해주는 것.
     *      "item" 네임 속성은? "item"이라는 이름으로 model.addAttribute해준다.
     *      그리고 Model도 날려도된다. 스프링이 모델 만들어서 하고 자동으로 들어간다.
     *      이름을 바꾸면 안될거다. 상품 상세에서 item이라는 네이밍으로 타임리프를 사용하기 떄문
     */
    //@PostMapping("/add")
    public String addItemV2(@ModelAttribute("item") Item item){

        itemRepository.save(item);

        // 자동추가, 생략가능
        // model.addAttribute("item",item);
        return "basic/item";
    }

    /**
     * @ModelAttribute name 생략 가능
     * model.addAttribute(item); 자동 추가, 생략 가능
     * 생략시 model에 저장되는 name은 클래스명 첫글자만 소문자로 등록 Item -> item
     * if) HelloData --> helloData
     */
    //@PostMapping("/add")
    public String addItemV3(@ModelAttribute Item item) {
        itemRepository.save(item);
        return "basic/item";
    }

    /**
     * @ModelAttribute 자체 생략 가능
     * model.addAttribute(item) 자동 추가
     */
    //@PostMapping("/add")
    public String addItemV4(Item item) {
        itemRepository.save(item);
        return "basic/item";
    }

    /**
     * PRG - Post/Redirect/Get
     */
    //@PostMapping("/add")
    public String addItemV5(Item item) {
        itemRepository.save(item);
        return "redirect:/basic/items/" + item.getId();
    }

    /**
     * RedirectAttributes
     */
    @PostMapping("/add")
    public String addItemV6(Item item, RedirectAttributes redirectAttributes) {
        Item savedItem = itemRepository.save(item);
        //리다이렉트 관련 속성 넣기. 저장된 아이디와, 상태. true면 저장에서 넘어온거라고 생각할 것
        redirectAttributes.addAttribute("itemId", savedItem.getId());
        redirectAttributes.addAttribute("status", true);
        // redirect 속성에 지정한 itemId를 넣을 수 있다. 못 들어간 status는 쿼리파라미터로!
        return "redirect:/basic/items/{itemId}";
    }

    @GetMapping("/{itemId}/edit")
    public String editForm(@PathVariable Long itemId, Model model){
        Item item = itemRepository.findById(itemId);
        model.addAttribute("item",item);
        return "basic/editForm";
    }

    @PostMapping("/{itemId}/edit")
    public String edit(@PathVariable Long itemId, @ModelAttribute Item item){
        itemRepository.update(itemId,item);
        // 컨트롤러부터 상품상세가 처음부터 다시 호출된 것
        return "redirect:/basic/items/{itemId}";
    }


    // 테스트용 데이터 추가
    @PostConstruct
    public void init(){
        itemRepository.save(new Item("itemA",10000,10));
        itemRepository.save(new Item("itemB",20000,20));

    }
}
