package hello.itemservice.domain.item;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ItemRepository {

    // spring container내에서는 싱글톤이니까 상관없긴한데 변수생성 방지로 그냥 스태틱으로 둠
    // 멀티쓰레드 환경에서 Hasamap 쓰면안됨. 싱글톤 스태틱이니까! ConcurrentHashMap 쓰기
    private static final Map<Long,Item> store = new HashMap<>();
    private static long sequence = 0L; // 얘도 AtomicLong 등 다른 거로

    public Item save(Item item){
        item.setId(++sequence);
        store.put(item.getId(),item);
        return item;
    }

    public Item findById(Long id){
        return store.get(id);
    }

    public List<Item> findAll(){
        // 감싸서 하면, 실제 스토어에 변화없으니 안전하게 ,타입도 안전하게
        return new ArrayList<>(store.values());
    }

    // 실제로할땐 dto로. 중복 명확성에서는 명확성 우선
    public void update(Long itemId, Item updateParam){
        Item findItem = findById(itemId);
        findItem.setItemName(updateParam.getItemName());
        findItem.setPrice(updateParam.getPrice());
        findItem.setQuantity(updateParam.getQuantity());
    }

    public void clearStore(){
        store.clear();
    }


}
