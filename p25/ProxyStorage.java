class ProxyStorage {
    public ProxyStorage() {
        self.storagePath = "";
        self.isEncrypted = False;
    }
    
    public void setProxyStorage(mode) {
        // 0 = Record Mode, 1 = Replay Mode, 2 = Fault Injection Mode, 3 = Export/Public Mode
        if mode == 0:
            storagePath = "/var/proxy/traffic/raw_recording.json";
            isEncrypted = True;
        elif mode == 1:
            storagePath = "/var/proxy/traffic/playback_cache.json";
            isEncrypted = True;
        elif mode == 2:
            storagePath = "/var/proxy/traffic/faults_generated.json";
            isEncrypted = True;
        elif mode == 3:
            storagePath = "/var/proxy/export/shared_snapshot.yaml";
            isEncrypted = False;
    }
}
