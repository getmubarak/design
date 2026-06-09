// Base Class: A standard, fully featured UI Browser engine (The "Flying Bird")
class VisualUiBrowser {
    public void navigateTo(String url) {
        System.out.println("Navigating network socket to: " + url);
    }

    public String getPageSource() {
        return "<html><body><h1>Dashboard</h1></body></html>";
    }

    // The "Fly" method of the UI testing world: Requires a physical UI graphics pipeline
    public byte[] captureScreenShot() {
        System.out.println("Snapping visual pixels from OS window buffer...");
        return new byte[]{0x1F, 0x2D, 0x3A}; // Valid PNG pixel array bytes
    }
}

// Derived Class: A headless text-only emulator optimized for background scraping (The "Ostrich")
class HeadlessTextMockBrowser extends VisualUiBrowser {

    // Navigation and reading raw source text works completely fine without a UI window
    @Override
    public String getPageSource() {
        return "HEADLESS TEXT CONTENT: Mock Dashboard Page Source";
    }

    // CRITICAL LSP VIOLATION: A headless text browser cannot render pixels!
    // This is exactly like Ostrich.fly() throwing a "CannotFlyException"
    @Override
    public byte[] captureScreenShot() {
        throw new UnsupportedOperationException(
            "CATASTROPHIC ERROR: Headless Text Engine has no visual window pipeline! Cannot capture screenshots."
        );
    }
}
