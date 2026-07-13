// /Sprint-001/Story-003/tests/FeeStructureTest.java

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FeeStructureTest {
    @Test
    public void testFeeStructureCreation() {
        List<FeeComponent> components = new ArrayList<>();
        components.add(new FeeComponent("Tuition", 1000.0));
        
        FeeStructure feeStructure = new FeeStructure("FS001", "2026 Academic Year", components, true);
        
        assertEquals("FS001", feeStructure.getFeeStructureId());
        assertEquals("2026 Academic Year", feeStructure.getName());
        assertEquals(components, feeStructure.getFeeComponents());
        assertTrue(feeStructure.isActive());
    }
}